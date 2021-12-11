# FTP-LTM
Đồ án lập trình mạng FTP
Những thứ chưa làm :
client
- validate : tạo tài khoản
- chưa mã hoá pass
- tải lên file đã toàn tại : thông báo ghi đè hay ko
- kiểm tra tài khoản đã đăng ký chưa : gmail
- Có thể đăng nhập tài khoản anonymous để upload/download vào thư mục chung.
- Chia sẻ thư mục/file bất kỳ với quyền chỉ đọc hoặc full quyền cho một người dùng khác. Người
dùng đó sẽ nhận được thông báo khi có người chia sẻ file/thư mục cho mình.

server
▪ Cho phép/block người dùng download/upload.
▪ Gán quyền user đối với thư mục. User chỉ được upload/download với các thư mục có quyền.
▪ Cấu hình dung lượng lưu trữ tối đa của từng user. Kích thước file tối đa upload và download.
▪ Cho phép/block chức năng anonymous với user bất kỳ.
