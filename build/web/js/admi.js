let listQuestion = document.getElementById("listQuestion");
let btnAgregar = document.getElementById("btnAgregar");
let btnEditar = document.getElementById("btnEditar");
let listSurvey__body = document.getElementById("listSurvey__body");
let editVisible = true;
const init = () => {

    listQuestion.addEventListener("change", (e) => {
        if (e.target.tagName == "SELECT") {
            e.preventDefault();
            let card__body = e.target.parentNode;
            for (const item of card__body.children) {
                if (item.id == "dinamico") {
                    let container = item;
                    if (e.target.selectedIndex == 0) {
                        container.innerHTML = '<input required type="text" class="inputText" placeholder="Respuesta" name="respuesta1" style="width: 100%;">';
                    } else {
                        container.innerHTML = `<input required type="text" class="inputText" placeholder="Respuesta 1" name="respuesta1" style="width: 100%; margin-bottom:1em;">
                        <input required type="text" class="inputText" placeholder="Respuesta 2" name="respuesta2" style="width: 100%; margin-bottom:1em;">
                        <input required type="text" class="inputText" placeholder="Respuesta 3" name="respuesta3" style="width: 100%; margin-bottom:1em;">
                        <input required type="text" class="inputText" placeholder="Respuesta 4" name="respuesta4" style="width: 100%; margin-bottom:1em;">`;
                    }
                }
            }
        }
    });

    btnAgregar.addEventListener("click", (e) => {
        e.preventDefault();
        let cardCompl = document.getElementById("cards");
        let card = cardCompl.innerHTML = `<form class="card" method="post" action="PreguntasControlador">
        <div class="card__header">
            <p class="numero">${document.getElementById("cards").children.length+1})</p>
            <button type="submit" class="btn btn--vacio">
                <i class="fas fa-trash-alt"></i>
            </button>
        </div>
        <div class="card__body">
            <input required type="text" class="inputText" placeholder="Pregunta" name="txtPregunta">
            <select name="tipoPregunta" id="option">
                <option value="0">Complementar</option>
                <option value="1">Opción multiple</option>
            </select>
            <div id="dinamico">
                <!-- Aqui ira dinamico con js -->
                <input required type="text" class="inputText" placeholder="Respuesta" name="respuesta1" style="width: 100%;">
            </div>
            <button type="submit" class="btn btnGuardar" name="btnGuardar">Guardar</button>
        </div>
    </form>`;
    });
    card.innerHTML += cardCompl;
}

init();