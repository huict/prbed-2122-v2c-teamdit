pm.test("airport succesfully deleted!", () => {

    if(Object.values(pm.request.auth.bearer)[1].token.value === ""){
        throw new Error("Unauthorized");
    };

    pm.expect(pm.response.code).to.be.oneOf([200,202,204,404,403]);
    pm.expect(pm.request.url.toString() === "http://localhost:8080/employee/airport/"+pm.request.url.path[2]);
    pm.expect(pm.request.method === "DELETE");


});
