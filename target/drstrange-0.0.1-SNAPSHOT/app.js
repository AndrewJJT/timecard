document.getElementById("login").addEventListener("submit",function(e){
    e.preventDefault();
    console.log("about to do post request...")
    let promise = axios.post("http://localhost:8080/drstrange/main/login");

    promise.then(function(response){
        console.log(response)
    }).catch(function(response){
        console.log(response)
    })
})