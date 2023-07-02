import express from "express";
import MoviesController from "./movies.controller.js"; // New import

const router = express.Router();
router.route('/').get(MoviesController.apiGetMovies); // Added a new home route

export default router;