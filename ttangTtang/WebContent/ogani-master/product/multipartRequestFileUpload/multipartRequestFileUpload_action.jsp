<html>
 
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(
    function() {
        // 태그에 onchange를 부여한다.
        $('#file').change(function() {
                addPreview($(this)); //preview form 추가하기
        });
    });
 
    // image preview 기능 구현
    // input = file object[]
    function addPreview(input) {
        if (input[0].files) {
            //파일 선택이 여러개였을 시의 대응
            for (var fileIndex = 0 ; fileIndex < input[0].files.length ; fileIndex++) {
                var file = input[0].files[fileIndex];
                var reader = new FileReader();
 
                reader.onload = function (img) {
                    //div id="preview" 내에 동적코드추가.
                    //이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
                    $("#preview").append(
                        "<img src=\"" + img.target.result + "\"\/>"
                    );
                };
                
                reader.readAsDataURL(file);
            }
        } else alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
    }
 
</script>
</head>
 
<body>
    <!-- multiple attr 가 없다면 단일 이미지만 선택한다. -->
    <input id="file" type="file" multiple/>
 
    <!-- 해당 위치 안에 이미지가 쌓이게 된다. -->
    <div id="preview">
    </div>
</body>
 
</html>
