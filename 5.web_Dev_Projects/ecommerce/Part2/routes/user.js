const { verifyToken, verifyTokenAndAuthorization, verifyTokenAndAdmin } = require("./verifyToken");
const router = require("express").Router();

// UPDATE
router.put("/:id", verifyTokenAndAuthorization, async (req, res) => {
    if (req.body.password) {
        req.body.password = CryptoJS.AES.encrypt(
            req.body.password,
            process.env.PASS_SEC
        ).toString()
    }

    try {
        const updatedUser = await User.findByIdAndUpdate(req.params.id, {
            $set: req.body
        },
            { new: true }
        );
        res.status(200).json(updatedUser);
    } catch (err) {
        console.log(`ERROR UPDATING USER => ${err}`);
        res.status(500).json(err);
    }
});

// DELETE
router.delete("/id:", verifyTokenAndAuthorization, async (res, req) => {
    try {
        await User.findByIdAndDelete(req.params.id)
        res.status(200).json("User has been deleted...")
    } catch (err) {
        console.log(`ERROR DELETING USER => ${err}`);
        res.status(500).json(err);
    }
});

// GET USER
router.get("/find/:id", verifyTokenAndAdmin, async (res, req) => {
    try {
        const user = await User.findById(req.params.id);
        const { password, ...others } = user._doc;
        res.status(200).json(others);
    } catch (err) {
        console.log(`ERROR RETRIEVING USER => ${err}`);
        res.status(500).json(err);
    }
});

// GET ALL USERS 
router.get("/", verifyTokenAndAdmin, async (res, req) => {
    const query = req.query.new;
    try {
        const users = query
            ? await User.find().sort({ _id: -1 }).limit(5)
            : await User.find();
        res.status(200).json(users);
    } catch (err) {
        console.log(`ERROR RETRIEVING ALL USERS => ${err}`);
        res.status(500).json(err);
    }
});

// GET USER STATS 
router.get("/stats", verifyTokenAndAdmin, async (req, res) => {
    const date = new Date();
    const lastYear = new Date(date.setFullYear(date.getFullYear() - 1));

    try {

        const data = await User.aggregate([
            { $match: { createdAt: { $gte: lastYear } } },
            {
                $project: {
                    month: { $month: "createdAt" },
                },
            },
            {
                $group: {
                    _id: "$month",
                    total: { $sum: 1 },
                }
            }
        ]);
        res.status(200).json(data);
    } catch (err) {
        res.status(500).json(err);
    }
});

module.exports = router;