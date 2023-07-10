// Stores reference to the DB
let movies

export default class MoviesDAO {
    static async injectDB(conn) {
        if (movies) {
            return
        }
        try {
            movies = await conn.db(process.env.MOVIEREVIEWS_NS).collection('movies');
        }
        catch (e) {
            console.error(`Unable to connect in MoviesDAO: ${e}`)
        }
    }


    static async getMovies({
        filters = null,
        page = 0,
        moviesPerPage = 20,
    } = {}) {
        let query
        if (filters) {
            if (filters.hasOwnProperty('title')) {
                query = { $text: { $search: filters['title'] } }
            } else if (filters.hasOwnProperty("rated")) {
                query = { "rated": filters['rated'] }
            }
        }

        let cursor
        try {
            cursor = await movies
                .find(query)
                .limit(moviesPerPage)
                .skip(moviesPerPage * page)
            const moviesList = await cursor.toArray();
            const totalNumMovies = await movies.countDocuments(query);
            return { moviesList, totalNumMovies }
        }
        catch (e) {
            console.error(`Unable to issue find command, ${e}`);
            return { moviesList: [], totalNumMovies: 0 }
        }
    }
}
