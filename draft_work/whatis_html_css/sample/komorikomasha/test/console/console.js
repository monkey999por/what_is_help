document.addEventListener(
  "DOMContentLoaded",
  () => {
    const input = document.querySelector('input[type="text"]#command');
    const logs = document.querySelector(".logs");

    input.addEventListener(
      "keypress",
      (e) => {
        if (e.keyCode === 13) {
          runCommand((args) => {
            console.log(args);
            return "result dayo-";
          });
          input.value = "";
          console.log(pBlock);
          console.log(input.value);
        }
      },
      false
    );
    /**
     * コマンドを実行して結果を表示
     *
     * @param commandFunc 実行するコマンド
     * @param args コマンドの引数
     */
    const runCommand = (commandFunc, args) => {
      // 実行したコマンド
      const history = document.createElement("p");
      const historyContent = document.createTextNode(
        `server@user$ ${input.value}`
      );

      // コマンドの結果
      const result = document.createElement("p");
      const resultContent = document.createTextNode(commandFunc(args));
      const cls = document.createAttribute("class");
      cls.value = "hash";
      result.setAttributeNode(cls);

      history.appendChild(historyContent);
      result.appendChild(resultContent);

      const div = document.createElement("div");
      div.appendChild(history);
      div.appendChild(result);

      logs.appendChild(div);
    };
  },
  false
);

//どこでもクリックすればinputにカーソルする
// inputのフォントサイズ
// コマンドにonforcusでスタイル変更
