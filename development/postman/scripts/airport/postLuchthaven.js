pm.test("airport succesfully made!",() => {
    if(Object.values(pm.request.auth.bearer)[1].token.value === ""){
        throw new Error("Unauthorized");
    };

    const data = pm.response.json();
    const input = JSON.parse(pm.request.body.raw);

    pm.expect(pm.request.method === "POST");

    pm.expect(typeof data.name == "string");
    pm.expect(typeof data.code == "string");
    pm.expect(typeof data.country == "string");
    pm.expect(typeof data.longitude == "number");
    pm.expect(typeof data.latitude == "number");

    pm.expect(input.name != null && typeof input.name == "string");
    pm.expect(input.code != null && typeof input.code == "string");
    pm.expect(input.country != null && typeof input.country == "string");
    pm.expect(input.longitude != null && typeof input.longitude == "number");
    pm.expect(input.latitude != null && typeof input.latitude == "number");

    pm.expect(pm.response.code).to.be.oneOf([200,201]);
    pm.expect(pm.request.url.toString() === "http://localhost:8080/employee/airport");
    pm.expect(pm.response.headers.get('Content-Type')).to.eql('application/json');


});
