import express from "express";
import MoviesController from "./movies.controller.js";
import ReviewsController from "./reviews.controller.js";


const router = express.Router();
router.route('/').get(MoviesController.apiGetMovies);

router
    .route("/review")
    .post(ReviewsController.apiPostReview) // For creating a review
    .put(ReviewsController.apiUpdateReview) // For editing a review
    .delete(ReviewsController.apiDeleteReview) // For deleting a review

export default router;