const data = pm.response.json();
pm.test("Luchthaven succesvol opgehaald", () => {
    pm.request.method.eql("GET");
    pm.expect(data.id).to.be.an("number");
    pm.expect(pm.response.code).to.eql(200);
    pm.expect(pm.request.body.isEmpty);
    pm.expect(pm.request.url.eql("localhost:8080/employee/luchthaven/")+ (pm.request.url[-1]) instanceof Number);
});
