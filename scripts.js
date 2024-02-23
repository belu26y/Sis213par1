let tasks = [];
let newTask = '';

// Al cargar la página, recuperar las tareas guardadas
window.onload = function() {
    if (localStorage.getItem('tasks')) {
        tasks = JSON.parse(localStorage.getItem('tasks'));
    }
}

function addTask() {
    const taskInput = document.getElementById("taskInput");
    newTask = taskInput.value.trim();
    if (newTask !== "") {
        tasks.push(newTask);
        localStorage.setItem('tasks', JSON.stringify(tasks));
        taskInput.value = "";
    }
}

function renderTasks() {
    const taskList = document.getElementById("taskList");
    taskList.innerHTML = "";
    tasks.forEach((task, index) => {
        const li = document.createElement("li");
        li.innerHTML = task;
        li.setAttribute("data-index", index);
        li.addEventListener("click", () => {
            selectTask(index);
        });
        taskList.appendChild(li);
    });
}

function editTask() {
    const selectedIndex = getSelectedIndex();
    if (selectedIndex !== -1) {
        const editedTask = prompt("Editar tarea:", tasks[selectedIndex]);
        if (editedTask !== null) {
            tasks[selectedIndex] = editedTask.trim();
            localStorage.setItem('tasks', JSON.stringify(tasks));
            renderTasks();
        }
    } else {
        alert("Por favor seleccione una tarea para editar.");
    }
}

function deleteTask() {
    const selectedIndex = getSelectedIndex();
    if (selectedIndex !== -1) {
        tasks.splice(selectedIndex, 1);
        localStorage.setItem('tasks', JSON.stringify(tasks));
        renderTasks();
    } else {
        alert("Por favor seleccione una tarea para eliminar.");
    }
}

function selectTask(index) {
    const lis = document.querySelectorAll("#taskList li");
    lis.forEach(li => {
        li.classList.remove("selected");
    });
    lis[index].classList.add("selected");
}

function getSelectedIndex() {
    const selectedLi = document.querySelector("#taskList li.selected");
    return selectedLi ? parseInt(selectedLi.getAttribute("data-index")) : -1;
}

function showAllTasks() {
    renderTasks();
}
