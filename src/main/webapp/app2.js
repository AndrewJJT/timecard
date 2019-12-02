function getUserInfo(){
    return axios.get("http://localhost:8080/drstrange/main/login")
}
function getTimeSheets(){
    return axios.get("http://localhost:8080/drstrange/main/edit")
}

document.addEventListener('DOMContentLoaded',function(e){

    axios.all([getTimeSheets(), getUserInfo()])
    .then(axios.spread(function(timesheet, userinfo){
        console.log(timesheet)
        console.log(userinfo)

        let username = document.getElementById('username')
        let firstname = userinfo.data.firstName
        let lastname = userinfo.data.lastName
        username.innerText = `${firstname}, ${lastname}`

        let tsobj = timesheet.data

        let weo = new Date(tsobj.weekEndingOn)
        let weekingondate = weo.toDateString()
        let weekendon = document.getElementById('olddate')
        weekendon.innerText = weekingondate
        weekendon.setAttribute('placeholder', tsobj.weekEndingOn)
        let monhrs = document.getElementById('mondayhours')
        monhrs.setAttribute('placeholder', tsobj.mondayHours + " Hours")
        let tueshrs = document.getElementById('tuesdayhours')
        tueshrs.setAttribute('placeholder', tsobj.tuesdayHours + " Hours")
        let wedhrs = document.getElementById('wednesdayhours')
        wedhrs.setAttribute('placeholder', tsobj.wednesdayHours + " Hours")
        let thurhrs = document.getElementById('thursdayhours')
        thurhrs.setAttribute('placeholder', tsobj.thursdayHours + " Hours")
        let frihrs = document.getElementById('fridayhours')
        frihrs.setAttribute('placeholder', tsobj.fridayHours + " Hours")
        let sathrs = document.getElementById('saturdayhours')
        sathrs.setAttribute('placeholder', tsobj.saturdayHours + " Hours")
        let sunhrs = document.getElementById('sundayhours')
        sunhrs.setAttribute('placeholder', tsobj.sundayHours + " Hours")

        let userid = document.getElementById('userid')
        userid.setAttribute('value', tsobj.userId)

        let tsid = document.getElementById('timesheetid')
        tsid.setAttribute('value',tsobj.id)
    })).catch(axios.spread(function(timesheet, userinfo){
        console.log(timesheet)
        console.log(userinfo)
    }))

})