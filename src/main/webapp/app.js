// axios.defaults.withCredentials = true
// Load page after signed in and get all timesheets belongs to user
function getTimeSheets(){
    return axios.get("http://localhost:8080/drstrange/main/timesheet")
}

function getUserInfo(){
    return axios.get("http://localhost:8080/drstrange/main/login")
}

document.addEventListener('DOMContentLoaded',function(){

    // let promise = axios.get("http://localhost:8080/drstrange/main/timesheet");
    
    // promise.then(function(response){
    //     console.log(response)
    //     createTable(response.data)

    // }).catch(function(response){
    //     console.log(response);
    // })

    axios.all([getTimeSheets(), getUserInfo()])
    .then(axios.spread(function(timesheet, userinfo){
        console.log(timesheet)
        console.log(userinfo)
        let username = document.getElementById('username')
        let firstname = userinfo.data.firstName
        let lastname = userinfo.data.lastName
        username.innerText = `${firstname}, ${lastname}`

        createTable(timesheet.data)
    })).catch(axios.spread(function(timesheet, userinfo){
        console.log(timesheet)
        console.log(userinfo)
    }))

})

// ADD TimeSheet
document.getElementById('addtimesheet').addEventListener('click', function(e){
    e.preventDefault(); 
    console.log("statusid: " + e.target.id)
    // create an object then use post request to send the object
    let newtimesheet = {
        mondayHours : document.getElementById('mondayhours').value,
        tuesdayHours : document.getElementById('tuesdayhours').value,
        wednesdayHours : document.getElementById('wednesdayhours').value,
        thursdayHours : document.getElementById('thursdayhours').value,
        fridayHours : document.getElementById('fridayhours').value,
        saturdayHours : document.getElementById('saturdayhours').value,
        sundayHours : document.getElementById('sundayhours').value,
        weekEndingOn: document.getElementById('weekendingon').value,
        userId: 1,
        statusId: e.target.id 
    }
    let promise = axios.post("http://localhost:8080/drstrange/main/timesheet", newtimesheet)
    promise.then(response=>{
        // make a call to create time sheet 
        console.log(response)
        // append responsed timesheet 
        var i = response.data;
        
        let tr = document.createElement('tr')
        tr.setAttribute('id', 'rowid'+i.id)
        let td_mon = document.createElement('td')
        td_mon.innerText = i.mondayHours
        let td_tues = document.createElement('td')
        td_tues.innerText = i.tuesdayHours
        let td_wed = document.createElement('td')
        td_wed.innerText = i.wednesdayHours
        let td_thur = document.createElement('td')
        td_thur.innerText = i.thursdayHours
        let td_fri = document.createElement('td')
        td_fri.innerText = i.fridayHours
        let td_sat = document.createElement('td')
        td_sat.innerText = i.saturdayHours
        let td_sun = document.createElement('td')
        td_sun.innerText = i.sundayHours
        let td_weekendingon = document.createElement('td')
        weo = new Date(i.weekEndingOn)
        weo2 = weo.toLocaleString()
        // let weekingondate = `${weo.getFullYear()}-${weo.getMonth()}-${weo.getDate()}`
        let weekingondate = weo.toDateString()
        td_weekendingon.innerText = weekingondate
        let td_action = document.createElement('td')
        if(i.statusId == 1){
            // create form for edit -- start 
            let form_edit = document.createElement('form')
            form_edit.setAttribute('method', 'POST')
            form_edit.setAttribute('action', '/drstrange/main/edit')

            let id = document.createElement('input')
            id.hidden = true
            id.setAttribute('value',i.id)
            id.setAttribute('name','timesheetid')

            let edit = document.createElement('input')
            edit.setAttribute('class','btn btn-primary')
            edit.setAttribute('type',"submit")
            edit.setAttribute('value','Edit')

            form_edit.appendChild(id)
            form_edit.appendChild(edit)
            // form for edit -- end

            // create form for delete--start 
            let form_del = document.createElement('form')
            form_del.setAttribute('id', 'deltimesheet')
   
            let div_formrow = document.createElement('div')
            div_formrow.setAttribute('class', 'form-row')

            let del = document.createElement('button')
            del.setAttribute('class','btn btn-danger')
            del.setAttribute('type','submit')
            del.setAttribute('id',i.id)
            del.innerText = 'Delete'

            div_formrow.appendChild(del)

            form_del.appendChild(div_formrow)
            // end form for delete

            td_action.appendChild(form_edit)
            td_action.appendChild(form_del)
        }else{
            td_action.innerText ="Submitted! Can't be Changed!"
        }
        tr.appendChild(td_mon)
        tr.appendChild(td_tues)
        tr.appendChild(td_wed)
        tr.appendChild(td_thur)
        tr.appendChild(td_fri)
        tr.appendChild(td_sat)
        tr.appendChild(td_sun)
        tr.appendChild(td_weekendingon)
        tr.appendChild(td_action)
   
        let body = document.getElementById('tbody')
        body.appendChild(tr)
        
        
    }).catch(response=>{
        console.log(response)
    })
})


// DELETE/EDIT/SUBMIT
document.getElementById('table').addEventListener('click',function(e){
    if(e.target.id){
        e.preventDefault()
            let id = e.target.id
            let promise = axios.delete(`http://localhost:8080/drstrange/main/timesheet?timesheetid=${id}`)
            promise.then(response=>{
                console.log(response)
            
                let rowTobeRemoved = document.getElementById("rowid"+id)
                rowTobeRemoved.remove()
                
            }).catch(response=>{
                console.log(response)
            })
        }
    })




// CREATE TABLE
function createTable (timecardarray){
    let table = document.createElement('table')
    table.setAttribute('id','table')
    table.setAttribute('class','table')
    // set up thead
    let thead = document.createElement('thead');
    let tr = document.createElement('tr')
    let mon_th = document.createElement('th')
    mon_th.innerText = 'Monday Hours'
    let tues_th = document.createElement('th')
    tues_th.innerText = 'Tuesday Hours'
    let wed_th = document.createElement('th')
    wed_th.innerText = 'Wednesday Hours'
    let thur_th = document.createElement('th')
    thur_th.innerText = 'Thursday Hours'
    let fri_th = document.createElement('th')
    fri_th.innerText = 'Friday Hours'
    let sat_th = document.createElement('th')
    sat_th.innerText = 'Saturday Hours'
    let sun_th = document.createElement('th')
    sun_th.innerText = 'Sunday Hours'
    let weekendingon_th = document.createElement('th')
    weekendingon_th.innerText = 'Week Ending On'
    let action_th = document.createElement('th')
    action_th.innerText = 'Action'
    tr.appendChild(mon_th)
    tr.appendChild(tues_th)
    tr.appendChild(wed_th)
    tr.appendChild(thur_th)
    tr.appendChild(fri_th)
    tr.appendChild(sat_th)
    tr.appendChild(sun_th)
    tr.appendChild(weekendingon_th)
    tr.appendChild(action_th)
    
    thead.appendChild(tr)
    table.appendChild(thead)

    // set up tbody
    let tablebody = document.createElement('tbody')
    tablebody.setAttribute("id","tbody")
    
    // put data in the table body
    for(let i of timecardarray){
        let tr = document.createElement('tr')
        tr.setAttribute('id', 'rowid'+i.id)
 
        let td_mon = document.createElement('td')
        td_mon.innerText = i.mondayHours
        let td_tues = document.createElement('td')
        td_tues.innerText = i.tuesdayHours
        let td_wed = document.createElement('td')
        td_wed.innerText = i.wednesdayHours
        let td_thur = document.createElement('td')
        td_thur.innerText = i.thursdayHours
        let td_fri = document.createElement('td')
        td_fri.innerText = i.fridayHours
        let td_sat = document.createElement('td')
        td_sat.innerText = i.saturdayHours
        let td_sun = document.createElement('td')
        td_sun.innerText = i.sundayHours
        let td_weekendingon = document.createElement('td')
        let weo = new Date(i.weekEndingOn)
        let weekingondate = weo.toDateString()
        td_weekendingon.innerText = weekingondate
        let td_action = document.createElement('td')
        if(i.statusId == 1){
            
            // create form for edit -- start 
            let form_edit = document.createElement('form')
            form_edit.setAttribute('method', 'POST')
            form_edit.setAttribute('action', '/drstrange/main/edit')

            let id = document.createElement('input')
            id.hidden = true
            id.setAttribute('value',i.id)
            id.setAttribute('name','timesheetid')

            let edit = document.createElement('input')
            edit.setAttribute('class','btn btn-primary')
            edit.setAttribute('type',"submit")
            edit.setAttribute('value','Edit')

            form_edit.appendChild(id)
            form_edit.appendChild(edit)
            // form for edit -- end

            // create form for delete--start 
            let form_del = document.createElement('form')
            form_del.setAttribute('id', 'deltimesheet')
   
            let div_formrow = document.createElement('div')
            div_formrow.setAttribute('class', 'form-row')

            let del = document.createElement('button')
            del.setAttribute('class','btn btn-danger')
            del.setAttribute('type','submit')
            del.setAttribute('id',i.id)
            del.innerText = 'Delete'

            div_formrow.appendChild(del)

            form_del.appendChild(div_formrow)
            // end form for delete

            td_action.appendChild(form_edit)
            td_action.appendChild(form_del)
        }else{
            td_action.innerText ="Submitted! Can't be Changed!"
        }
   
        tr.appendChild(td_mon)
        tr.appendChild(td_tues)
        tr.appendChild(td_wed)
        tr.appendChild(td_thur)
        tr.appendChild(td_fri)
        tr.appendChild(td_sat)
        tr.appendChild(td_sun)
        tr.appendChild(td_weekendingon)
        tr.appendChild(td_action)
        tablebody.appendChild(tr)
    }

    table.appendChild(tablebody)

    document.getElementById('table').appendChild(table);
}

