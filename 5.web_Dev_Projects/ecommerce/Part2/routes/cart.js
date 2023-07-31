const Cart = require("../models/Cart");
const {
    verifyToken,
    verifyTokenAndAuthorization,
    verifyTokenAndAdmin
} = require("./verifyToken");

const router = require("express").Router();

// CREATE CART
router.post("/", verifyToken, async (req, res) => {
    const newCart = new Cart(req.body)

    try {
        const savedCart = await newCart.save();
        res.status(200).json(savedCart);
    } catch (err) {
        console.log(`ERROR CREATING CART => ${err}`)
        res.status(500).json(err);
    }
});

// UPDATE CART
router.put("/:id", verifyTokenAndAuthorization, async (req, res) => {
    try {
        const updatedCart = await Cart.findByIdAndUpdate(
            req.params.id,
            {
                $set: req.body
            },
            { new: true }
        );
        res.status(200).json(updatedCart);
    } catch (err) {
        console.log(`ERROR UPDATING CART => ${err}`);
        res.status(500).json(err);
    }
});

// DELETE PRODUCT
router.delete("/id:", verifyTokenAndAuthorization, async (res, req) => {
    try {
        await Cart.findByIdAndDelete(req.params.id)
        res.status(200).json("Cart has been deleted...")
    } catch (err) {
        console.log(`ERROR DELETING PRODUCT => ${err}`);
        res.status(500).json(err);
    }
});

// GET USER CART
router.get("/find/:id", verifyTokenAndAuthorization, async (res, req) => {
    try {
        const cart = await Cart.findOne({ userId: req.params.userId });
        res.status(200).json(cart);
    } catch (err) {
        console.log(`ERROR RETRIEVING PRODUCT => ${err}`);
        res.status(500).json(err);
    }
});

// GET ALL PRODUCTS

router.get("/", verifyTokenAndAdmin, async (req, res) => {
    try {
        const carts = await Cart.find();
        res.status(200).json(carts);
    } catch (err) {
        console.log(`ERROR FINDING ALL PRODUCTS => ${err}`);
        res.status(500).json(err);
    }

});


module.exports = router;