import app from "./server.js";
import mongodb from "mongodb";
import dotenv from "dotenv";
import MoviesDAO from "./dao/moviesDAO.js"; // **Ch7 Addition to index.js

// pg 31/32 
// This function connects to the cluster and calls functions that access our DB
async function main() {

    dotenv.config();

    const client = new mongodb.MongoClient(
        process.env.MOVIEREVIEWS_DB_URI
    )
    
    const port = process.env.PORT || 8000;

    try {
        // Connect to the MongoDB cluster
        await client.connect();
        await MoviesDAO.injectDB(client); // **

        app.listen(port, () => {
            console.log(`Server is running on port: ${port}`);
        })
    } catch (e) {
        console.error(e);
        process.exit(1)
    }
}
main().catch(console.error);