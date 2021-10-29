pm.test("airport succesfully fetched!", () => {
    if(Object.values(pm.request.auth.bearer)[1].token.value === ""){
        throw new Error("Unauthorized");
    };

    let data = pm.response.json();
    pm.expect(data).to.have.all.keys('code', 'airportName','city','country','longitude','latitude');
    pm.expect(pm.response.code).to.eql(200);
    pm.expect(pm.request.url.toString() === "http://localhost:8080/employee/airport/"+pm.request.url.path[2]);
    pm.expect(pm.request.method === "GET");
    pm.expect([...Object.values(data)].includes(null) == false);
    pm.expect(pm.response.headers.get('Content-Type')).to.eql('application/json');

});
