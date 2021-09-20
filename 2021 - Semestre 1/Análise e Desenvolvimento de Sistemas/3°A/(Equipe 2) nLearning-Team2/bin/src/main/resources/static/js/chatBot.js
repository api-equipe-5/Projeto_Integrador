(function () {
        window.onload = function () {
	
	var customStyle = `#message-input {
              box-sizing: border-box;
              border: 1px solid #0CC8CC;
              border-radius: 6px;
              background: #252B39;
            }
            #message-input textarea {
              background: #252B39;
              font-size: 12px;
              color: white;
            }`

            new BlipChat()
            .withAppKey('bmxlYXJuaW5nY2hhdDoxYjZiNDg3Zi02Y2RiLTRiOWItYTE5ZS1iNTdmYmY5YmU5Zjg=')
            .withButton({"color":"#060606","icon":"https://blipmediastore.blob.core.windows.net/public-medias/Media_e3842838-fc33-4da2-8b4a-bb116dcd808a"})
			.withCustomStyle(customStyle)
            .withCustomCommonUrl('https://chat.blip.ai/')
            .build();
        }
    })();