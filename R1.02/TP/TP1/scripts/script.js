let para = document.getElementById("nom");

para.addEventListener("click", updateName);

function updateName() {
  let name = prompt("Saisir un nouveau nom");
  if (name) {
    para.textContent = "Collaborateur : " + name;
  } else {
    para.textContent = "Saisir votre nom : ";
  }
}
