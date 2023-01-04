const timer = 2000;
const ui = document.getElementById("ui");

setInterval(() => {
  console.log("change");
  ui.classList.toggle("switch");
}, timer);
