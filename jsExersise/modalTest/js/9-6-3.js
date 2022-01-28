// テキストを含む一般的なモーダル
$(".info").modaal({
    // モーダル背景クリック時に閉じるか
    overlay_close: true,
    // モーダルが開く前に行う動作
    before_open: function () {
        /*縦スクロールバーを出さない*/
        $('html').css('overflow-y', 'hidden');
    },
    // モーダルが閉じた後に行う動作
    after_close: function () {
        /*縦スクロールバーを出す*/
        $('html').css('overflow-y', 'scroll');
    }
});

// 確認を促すモーダル
$(".confirm").modaal({
    type: 'confirm',
    // 確認画面タイトル
    confirm_title: 'ログイン',
    // 確認画面ボタンのテキスト
    confirm_button_text: 'Login',
    // 確認画面キャンセルボタンのテキスト
    confirm_cancel_button_text: 'やめる',
    // 確認画面の内容
    confirm_content: 'ログインが必要です。<br>この画面はボタンを押さなければ閉じません。',
});


// 画像のモーダル
$(".gallery").modaal({
    type: 'image',
    // モーダル背景クリック時に閉じるか
    overlay_close: true,
    // モーダルが開く前に行う動作
    before_open: function () {
        /*縦スクロールバーを出さない*/
        $('html').css('overflow-y', 'hidden');
    },
    // モーダルが閉じた後に行う動作
    after_close: function () {
        /*縦スクロールバーを出す*/
        $('html').css('overflow-y', 'scroll');
    }
});

// 動画のモーダル
$(".video-open").modaal({
    type: 'video',
    // モーダル背景クリック時に閉じるか
    overlay_close: true,
    // 背景色
    background: '#28BFE7',
    // 透過具合
    overlay_opacity: 0.8,
// モーダルが開く前に行う動作
    before_open: function () {
/*縦スクロールバーを出さない*/
        $('html').css('overflow-y', 'hidden');
    },
// モーダルが閉じた後に行う動作
    after_close: function () {
/*縦スクロールバーを出す*/
        $('html').css('overflow-y', 'scroll');
    }
});

//iframeのモーダル
$(".iframe-open").modaal({
    type: 'iframe',
    width: 800,//iframe横幅
    height: 800,//iframe高さ
    overlay_close: true,//モーダル背景クリック時に閉じるか
    before_open: function () {// モーダルが開く前に行う動作
        $('html').css('overflow-y', 'hidden');/*縦スクロールバーを出さない*/
    },
    after_close: function () {// モーダルが閉じた後に行う動作
        $('html').css('overflow-y', 'scroll');/*縦スクロールバーを出す*/
    }
});