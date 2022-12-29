module.exports = {
  files: "./test/**", //監視するファイルを指定
  server: {
    //デフォルトで開くファイルを指定
    baseDir: "./test/style_test/layout/", //ファイルまでのディレクトリのパス
    index: "layout.html", //ファイル名
  },
  proxy: false,
  port: 8000, //使用するポート番号
};
