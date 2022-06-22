//htmlのul要素（id = 'messages'）を呼び出し
var messageList = $('#messages');

//openweathermap（天気予報API）に接続
var request = new XMLHttpRequest();
var owmApiKey = "7c830b9179ba2a337562524e56a0f914";
var owmURL = "https://api.openweathermap.org/data/2.5/onecall?lat=26.21520643461992&lon=127.67872980512391&lang=jp&units=metric&exclude=current,minutely,hourly,alerts&appid="+ owmApiKey +"";




request.open('GET', owmURL, true);
//結果をjson型で受け取る
request.responseType = 'json';
request.onload = function () {
 let data = this.response;
 console.log(data);

var messageElement = $("<p></p>");
messageElement.append("<tr>");
for(let i = 1; i< 8; i++){
messageElement.append("<td p class='weather'>" + date(data['daily'][i]['dt']) + "</td>");
}
messageElement.append("</tr>");
messageElement.append("<tr>");
for(let i = 1; i< 8; i++){
messageElement.append("<td p class='weather'>" + data['daily'][i]['weather'][0]['main'] + "</td>");
}
messageElement.append("</tr>");
messageElement.append("<tr>");
  let icon;
  for(let i = 1; i< 8; i++){
  icon = data['daily'][i]['weather'][0]['icon'];
  console.log(icon);
  
  
  
  messageElement.append("<td p class='weather'><img src='http://openweathermap.org/img/w/" + icon +".png'></td>");
  
  }
messageElement.append("</tr>");


function date(dt){
  var date = new Date(dt*1000);
  var week = ['Sun','Mon','Tue','Wed','Thur','Fri','Sat'];
  var s =  date.getMonth()+1+'/';
  s += date.getDate()+'日';
  s += week[date.getDay()];
  return s;
};

 //HTMLに取得したデータを追加する
 messageList.append(messageElement);
};

request.send();