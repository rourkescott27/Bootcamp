/*exports.respondWithName = (req, res) => {
    res.render("index");
};*/

exports.respondWithName = (req, res) => {
    let paramsName = req.params.myName;
    res.render("index", { name: paramsName });
};