const authenticatedAccount = (req, res, next) => {
  if (!req.user) {
    const error = new Error('Invalid session');
    error.statusCode = 400;
    throw error;
  } else {
    next();
  }
};

module.exports = { authenticatedAccount };