package antena.utils;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;

public final class Jwt {

	public Algorithm SecretWord = Algorithm.HMAC256("antena-project");
	
	public String GenerateJwt(String email) {
		// set key to generate jwt
		String token = new String();

		// try to generate jwt
		try {
			token = JWT.create()
					.withClaim("email", email)
					.withIssuer("auth0")
					.sign(this.SecretWord);
		}catch(JWTCreationException ex){throw ex;}
		return token;
	}
	
	public String verifyJwt( String Tolken ) {	
		String email;
		try {
			email = getClaimFromToken(Tolken);
			
		    JWTVerifier verifier = JWT.require(this.SecretWord)
		    	.withClaim("email", email)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		     verifier.verify(Tolken);
		} catch (JWTVerificationException ex){return  null;}
		return email.length() > 0 ? email: null;
	}
	
	private String getClaimFromToken(String token) {
        Claim Claim = JWT.decode(token).getClaim("email");
        return Claim.asString();
    }
}
