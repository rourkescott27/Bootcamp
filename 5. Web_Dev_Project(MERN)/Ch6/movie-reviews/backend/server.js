import express from "express";
import cors from "cors";
import movies from "./api/movies.route.js";

const app = express();

app.use(cors());
app.use(express.json());

app.use("/api/v1/movies", movies);

// Added err and next as parameters
app.use('*', (err, req, res, next) => {
    console.log(err);
    res.status(404).json({error: "Not Found"})
});

export default app;