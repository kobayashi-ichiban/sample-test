const num_array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
let secretNumber = [];
let level;
let count = 0;

const selectLevels = document.getElementById("select");
const numberDisplay = document.getElementById("numberDisplay");
const nums = document.querySelectorAll(".num");
const choiceNumber = document.querySelectorAll("#choiceNumber");
    choiceNumber.forEach((value) => {
        value.addEventListener("click", selectNumber);
    });
const checkAnswerBtn = document.getElementById("checkAnswer");
    checkAnswerBtn.addEventListener("click", showHistory);
const clearAnswerBtn = document.getElementById("clearAnswer");
    clearAnswerBtn.addEventListener("click", clearNumber);
const table = document.querySelector("table");
const end = document.getElementById("end");

/* ゲーム開始処理 */
function startGame(selectLevel) {
    if (selectLevel > 1) {
        level = selectLevel;
        secretNumber = makeQuestionNumber(num_array);
        selectLevels.classList.add("hide");
    }
}

/* 問題作成 */
function makeQuestionNumber(num_array) {
    let alpha = num_array.length;
    while (alpha) {
        let j = Math.floor(Math.random() * alpha);
        let t = num_array[--alpha];
        num_array[alpha] = num_array[j]
        num_array[j] = t;
    }
    return num_array.slice(0, level);
}

/* 数値選択処理 */
function selectNumber(e) {
    if (numberDisplay.textContent.length === level - 1) {
        choiceNumber.forEach((value) => {
            value.classList.add("disable");
            checkAnswer.style.pointerEvents = "auto";
            return;
        });
    }
    if (numberDisplay.textContent.length < level) {
        numberDisplay.textContent = numberDisplay.textContent.concat(
            e.target.textContent
        );
        e.target.classList.add("disable");
    }
}

/* 履歴表示処理 */
function showHistory() {
    let answer = numberDisplay.textContent.split("").map(Number);
    if (answer.length === level) {
        count++;
        let result = isAnswer(answer, secretNumber);
        choiceNumber.forEach((value) => {
            value.classList.remove("disable");
        });
        checkAnswerBtn.style.pointerEvents = "none";

        table.rows[count].cells[1].textContent = `${numberDisplay.textContent}`;
        table.rows[count].cells[2].textContent = `${result.hit}`;
        table.rows[count].cells[3].textContent = `${result.blow}`;
        numberDisplay.textContent = `Hit: ${result.hit} Blow: ${result.blow}`;
        numberDisplay.textContent = "";
        isGameEnd(result.hit);
    }
}

/* 回答確認 */
function isAnswer(answer,secretNumber) {
    let hitBlow = {
        hit: 0,
        blow: 0,
    };
    secretNumber.forEach((value, index) => {
        if (secretNumber.indexOf(answer[index]) !== -1) {
            if (answer[index] === value) {
                hitBlow.hit++;
            } else {
                hitBlow.blow++;
            }
        }
    });
    return hitBlow;
}

/* ゲーム終了判定処理 */
function isGameEnd(hit) {
    if (hit === level) {
        end.children[0].textContent = "You WIN !";
        showGameEnd();
    } else if (count === 10) {
        end.children[0].textContent = "You LOSE..."
        showGameEnd();
    }
}

/* ゲーム終了画面表示 */
function showGameEnd() {
    end.classList.remove("hide");
    end.animate({ opacity: [0, 0.7] }, { duration: 1500 });
    end.children[1].textContent = secretNumber.join("");
    end.children[2].textContent = "Click Reset";
}

/* クリアボタン処理 */
function clearNumber() {
    numberDisplay.textContent = "";
    choiceNumber.forEach((value) => {
        value.classList.remove("disable");
    });
}
