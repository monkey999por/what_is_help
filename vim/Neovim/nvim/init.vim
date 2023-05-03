"行番号を表示
set number
"シンタックスハイライトをon
syntax on
"行末まで検索した後行頭に戻って検索
set wrapscan
"検索結果をハイライト表示(:nohで消す)
set showmatch
"tabの代わりにスペースを使用
set expandtab
"tabキーで挿入されるスペースの数
set shiftwidth=4
"中括弧を始めた後などの改行のあと自動的にインデントを入れる
set smartindent
"インデント周りの各種機能で操作されるスペースの数
set softtabstop=4
"VimではUTF-8で文字を表示する
set encoding=utf-8
"UTF-8でファイルを読み込み、ダメだったらShift_JISを試す
set fileencodings=utf-8,sjis
"UTF-8でファイルを書き込む
set fileencodings=utf-8
"クリップボードとVimの無名レジスタを結合する
set clipboard+=unnamed

" 検索系
" 検索文字列入力時に順次対象文字列にヒットさせる
set incsearch
" 検索時に最後まで行ったら最初に戻る
set wrapscan
" 検索語をハイライト表示
set hlsearch
" ESC連打でハイライト解除
nmap  :nohlsearch
" シンタックスハイライトの有効化
syntax enable


"Ctrl+J,Ctrl+Kでパラグラフ一つ分移動
nnoremap <C-j> }
nnoremap <C-k> {
"「s*」でカーソル下の単語からの置換を途中まで記述
nnoremap <expr> s* ':%s/\<' . expand('<cword>') . '\>/'


