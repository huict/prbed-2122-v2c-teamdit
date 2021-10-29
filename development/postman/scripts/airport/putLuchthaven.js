const data = pm.response.json();
pm.test("luchthaven succesvol aangepast",() => {
    pm.request.method.eql("PUT");
    pm.expect(data.name).to.be.a('string');
    pm.expect(data.city).to.be.a('string');
    pm.expect(data.code).to.be.a('string');
    pm.expect(data.longitude).to.be.a('double');
    pm.expect(data.latitude).to.be.a('double');
    pm.expect(pm.response.code).to.be.eql(200);
    pm.expect(pm.request.url.eql("localhost:8080/employee/luchthaven"));
});
