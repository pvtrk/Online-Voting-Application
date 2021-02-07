package pl.it.patryk.ova.security;

public class SecurityConstants {
    final static long EXPIRATION_TIME = 864_000_000; // 10 days ?
    final static String SECRET = "SecretKeyToGenJWTs";
    final static String TOKEN_PREFIX = "Bearer ";
    final static String HEADER_STRING = "Authorization";
    public final static String SIGN_UP_URL = "/user/sign-up";
    public final static String LOGIN_URL = "/user/login";
}
