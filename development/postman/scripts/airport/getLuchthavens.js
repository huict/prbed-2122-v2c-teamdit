pm.test("All airports succesfully fetched!", () => {

    if(Object.values(pm.request.auth.bearer)[1].token.value === ""){
        throw new Error("Unauthorized");
    };

    pm.expect(pm.response.code).to.eql(200);
    pm.expect(pm.request.url.toString() === "http://localhost:8080/employee/airport");
    pm.expect(pm.request.method === "GET");
    pm.expect(pm.response.headers.get('Content-Type')).to.eql('application/json');


})

