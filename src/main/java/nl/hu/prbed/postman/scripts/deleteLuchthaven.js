const data = pm.response.json();
pm.test("Luchthaven succesvol verwijderd", () => {
    pm.request.method.eql("DELETE");
    pm.expect(data.id).to.be.an("number");
    pm.expect(pm.response.code).to.be.oneOf([200,202,404]);
    pm.expect(pm.request.body.isEmpty);
    pm.expect(pm.request.url.eql("localhost:8080/employee/luchthaven/")+ (pm.request.url[-1]) instanceof Number)
});
