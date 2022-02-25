const num_array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
let secretNumber = [];
let level;
let count = 0;

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

/* 回答確認 */
function isAnswer(answer,secretNumber) {
    let hitBlow = {
        hit: 0,
        blow: 0,
    };
    secretNumber.forEach((value, index) => {
        if (secretNumber.indexOf(answer[index] !== -1) {
            hitBlow.hit++;
        } else {
            hitBlow.blow++;
        }
    });
    return hitBlow;
}

/* 数値選択処理 */
function selectNumber(e) {
    if (numberDisplay.textContent.length === level - 1) {
        choiceNumber.forEach((value) => {
            value.classList.add("disable");
            btn.style.pointerEvents = "auto";
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
