
//zie BEP2 casinoproject postman collection resource /register
if (pm.response.code === 200) {
    const authHeader = pm.response.headers.get("Authorization");
    const token = authHeader.substring(7);
    pm.collectionVariables.set("authToken", token);
}
