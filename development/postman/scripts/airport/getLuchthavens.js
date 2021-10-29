pm.test("Alle luchthavens succesvol opgehaald", () => {
    pm.request.method.eql("GET");
    pm.expect(pm.response.code).to.eql(200);
    pm.expect(pm.request.url.eql("localhost:8080/employee/luchthaven"))
    pm.expect(pm.request.body.isEmpty);

})

