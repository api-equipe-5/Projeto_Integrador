const passport = require('passport');
const GoogleStrategy = require('passport-google-oauth20').Strategy;
const keys = require('../../secrets/keys');
const AccountTable = require('../../app/account/table');
const { hash } = require('../../app/account/helper');

passport.serializeUser((user, done) => {
    done(null, user.userId);
});

passport.deserializeUser((id, done) => {
    AccountTable.getAccount(id).then((user) => {
        done(null, user);
    })
});

passport.use(
    new GoogleStrategy({
        callbackURL: '/auth/google/redirect',
        clientID: keys.google.clientID,
        clientSecret: keys.google.clientSecret
    }, ( accessToken, refreshToken, profile, done ) => {
        AccountTable.getAccount(profile.id)
        .then((account) => {
            if (account != undefined) {
                done(null, account);
            } else {
                AccountTable.storeAccount({ userId: profile.id, username: profile.displayName })
                .then((newAccount) => {
                    done(null, newAccount);
                });
            }
        });
    })    
);