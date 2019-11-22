document.getElementById('gettimesheet').addEventListener('click',function(e){
    e.preventDefault(); 

    let promise = axios.get("http://localhost:8080/drstrange/main/login");

    promise.then(function(response){

    console.log(response);
    createTable(response.data)
        
    })

    promise.catch(function(response){
        console.log(response);
    })

})


document.getElementById('save').addEventListener('submit', function(e){
    // create an object then use post request to send the object
})

function createTable (timecardarray){
    let table = document.createElement('table')
    table.setAttribute("class","table")
    let thead = document.createElement('thead');
    let tr = document.createElement('tr')
    let mon_th = document.createElement('th')
    mon_th.innerText = "Monday Hours"
    let tues_th = document.createElement('th')
    tues_th.innerText = "Tuesday Hours"
    let wed_th = document.createElement('th')
    wed_th.innerText = "Wednesday Hours"
    let thur_th = document.createElement('th')
    thur_th.innerText = "Thursday Hours"
    let fri_th = document.createElement('th')
    fri_th.innerText = "Friday Hours"
    let sat_th = document.createElement('th')
    sat_th.innerText = "Saturday Hours"
    let sun_th = document.createElement('th')
    sun_th.innerText = "Sunday Hours"
    tr.appendChild(mon_th)
    tr.appendChild(tues_th)
    tr.appendChild(wed_th)
    tr.appendChild(thur_th)
    tr.appendChild(fri_th)
    tr.appendChild(sat_th)
    tr.appendChild(sun_th)
    
    thead.appendChild(tr)
    table.appendChild(thead)

    let tablebody = document.createElement('tbody')
    
    for(let i of timecardarray){
        let tr = document.createElement('tr')
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
        tr.appendChild(td_mon)
        tr.appendChild(td_tues)
        tr.appendChild(td_wed)
        tr.appendChild(td_thur)
        tr.appendChild(td_fri)
        tr.appendChild(td_sat)
        tr.appendChild(td_sun)
        tablebody.appendChild(tr)
    }

    table.appendChild(tablebody)

    document.getElementById('table').appendChild(table);
}

