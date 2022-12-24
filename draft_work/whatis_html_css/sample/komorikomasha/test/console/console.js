const commandHistory = [];
let keyPressCount = 0;

document.addEventListener(
  "DOMContentLoaded",
  () => {
    const server = document.querySelector(".server");
    const user = document.querySelector(".user");
    const input = document.querySelector('input[type="text"]#command');
    const logs = document.querySelector(".logs");

    server.textContent = "192.168.0.1";
    user.textContent = "monkey999";

    input.focus();

    input.addEventListener(
      "keydown",
      (e) => {
        // 上押下
        if (e.keyCode === 38) {
          if (commandHistory) {
            if (commandHistory.length >= keyPressCount + 1) {
              keyPressCount++;
            }

            const temp = commandHistory[commandHistory.length - keyPressCount];
            input.value = temp ? temp : "";
          }
        } else if (e.keyCode === 40) {
          // 下押下
          if (
            commandHistory.length >= keyPressCount - 1 &&
            commandHistory.length <= keyPressCount - 1
          ) {
            keyPressCount--;
          }
          console.log(commandHistory.length - keyPressCount);
          const temp = commandHistory[commandHistory.length - keyPressCount];
          input.value = temp ? temp : "";
        }

        // Enter押下時
        if (e.keyCode === 13) {
          keyPressCount = 0;
          runCommand(ssh);
          input.value = "";
        }
        // 一番下にスクロール
        const element = document.documentElement;
        const bottom = element.scrollHeight - element.clientHeight;
        window.scroll(0, bottom);
      },
      false
    );
    /**
     * コマンドを実行して結果を表示
     *
     * @param commandFunc 実行するコマンド
     * @param args コマンドの引数
     */
    const runCommand = (commandFunc) => {
      // コマンド実行
      const result = commandFunc(input.value);

      // 履歴の保存
      // 上ボタン、下ボタンで使う。
      commandHistory.push(input.value);

      // 結果生成
      // 実行したコマンド
      const historyElement = document.createElement("p");
      historyElement.textContent = `${server.textContent}@${user.textContent}$ ${input.value}`;

      // コマンドの結果
      const resultElement = document.createElement("p");
      resultElement.textContent = result;

      const group = document.createElement("div");
      group.setAttribute("class", "histories");

      group.appendChild(historyElement);
      group.appendChild(resultElement);
      logs.appendChild(group);
    };

    // 画面クリックでコマンド入力にフォーカス
    document.addEventListener("click", () => input.focus(), false);
  },
  false
);

// const commands = [
//   {
//     name: "ssh",
//     func: ssh,
//   },
// ];

/**
 * ssh mock
 */
const ssh = (args) => {
  const sshFormat = /[0-9]{3}\.[0-9]{3}\.[0-9]{1,3}\.[0-9]{1,3}@.+/gi;
  if (sshFormat.test(args)) {
    console.log("ok");
  } else {
    console.log("ng");
  }
  const server = document.querySelector(".server");
  const user = document.querySelector(".user");

  return `login to ${args}`;
};

// 上ボタンで履歴をたどる
// コマンドの一つ目で関数を特定
