export const oktaConfig ={
    clientId:'0oa9rfk078I1jo3K15d7',
    issuer:'https://dev-98777048.okta.com/oauth2/default',
    redirectUri:'https://localhost:3000/login/callback',
    scopes:['openid','profile','email'],
    pkce:true,
    disableHttpsCheck:true,
}