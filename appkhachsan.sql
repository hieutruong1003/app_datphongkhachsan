-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 02, 2020 lúc 03:13 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `appkhachsan`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `datphong`
--

CREATE TABLE `datphong` (
  `madp` int(11) NOT NULL,
  `makh` int(11) NOT NULL,
  `maphong` char(3) NOT NULL,
  `ngayden` varchar(100) NOT NULL,
  `ngaydi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `datphong`
--

INSERT INTO `datphong` (`madp`, `makh`, `maphong`, `ngayden`, `ngaydi`) VALUES
(1, 187801779, 'A03', '02/12/2020', '03/12/2020'),
(12, 187801779, 'B03', '02/12/2020', '03/12/2020'),
(13, 187801779, 'A03', '02/12/2020', '03/12/2020'),
(14, 187801779, 'G03', '02/12/2020', '03/12/2020'),
(15, 187801779, 'G04', '02/12/2020', '03/12/2020');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(14) NOT NULL,
  `tenkh` varchar(200) NOT NULL,
  `gioitinh` char(1) NOT NULL,
  `sdt` varchar(12) NOT NULL,
  `email` varchar(200) NOT NULL,
  `diachi` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkh`, `gioitinh`, `sdt`, `email`, `diachi`) VALUES
(187801779, 'Truong Van Hieu', '1', '0369559606', 'hieu@gmail.com', '133 Đỗ Thúc Tinhh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachsan`
--

CREATE TABLE `khachsan` (
  `maks` char(4) NOT NULL,
  `tenks` varchar(300) NOT NULL,
  `sdt` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `diachi` varchar(300) NOT NULL,
  `hinhanh` varchar(1000) NOT NULL,
  `mota` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachsan`
--

INSERT INTO `khachsan` (`maks`, `tenks`, `sdt`, `email`, `diachi`, `hinhanh`, `mota`) VALUES
('ks01', 'Khách Sạn Mường Thanh Luxury.', '0369559606', 'hieu_1751220089@dau.edu.vn', '270 Võ Nguyên Giáp, Bắc Mỹ Phú, Ngũ Hành Sơn, Đà Nẵng', 'https://pix6.agoda.net/hotelImages/745965/-1/3c748fa5e7feede4aea8105dab5c90a5.jpg', 'Tìm kiếm một khách sạn sang trọng lý tưởng ở Đà Nẵng không phải là quá khó. Chào đón bạn đến với Khách sạn Mường Thanh Luxury Đà Nẵng, một lựa chọn đúng đắn cho những du khách như bạn.\r\n\r\nNằm gần các địa danh như DHC Marina (2,1 km) và Cầu Sông Hàn (2,9 km) đã làm Khách sạn Mường Thanh Luxury Đà Nẵng trở thành lựa chọn lý tưởng khi đến Đà Nẵng.\r\n\r\nCác phòng tại Khách sạn Mường Thanh Luxury Đà Nẵng cung cấp điều hòa nhiệt độ và quầy bar mini, và khách có thể được kết nối wifi miễn phí.\r\n\r\nNgoài ra, khi nghỉ dưỡng tại Khách sạn Mường Thanh Luxury Đà Nẵng khách có thể dùng dịch vụ phòng, nhân viên hỗ trợ khách và sân thượng. Bạn cũng có thể tận hưởng bể bơi và bữa sáng. Cần chỗ đỗ xe ? Đỗ xe miễn phí có sẵn tại Khách sạn Mường Thanh Luxury Đà Nẵng.\r\n\r\nKhi đến Đà Nẵng, bạn có thể muốn thử tôm hùm tại một trong những nhà hàng lân cận như Hải Sản Bé Mặn, Le Bambino hoặc Red Sky Bar & Restaurant.\r\n\r\nTrên hết, Khách sạn Mường Thanh Luxury Đà Nẵng làm đơn giản hoá việc trải nghiệm những điểm đến tuyệt vời ở Đà Nẵng như Art in Paradise (3D TRICK ART) và Bảo Tàng Mỹ Thuật Đà Nẵng, cũng là những viện bảo tàng nghệ thuật được yêu thích.\r\n\r\nKhách sạn Mường Thanh Luxury Đà Nẵng mong muốn được chào đón bạn trong chuyến đi đến Đà Nẵng của bạn.'),
('ks02', 'Khách sạn Brilliant Đà Nẵng', '0369559606', 'hieu_1751220089@dau.edu.vn', '162 Bạch Đằng, P.Hải Châu1, Q.Hải Châu, Đà Nẵng.', 'http://brillianthotel.vn/upload/hinhanh/33444392-9206.jpg', 'Khách sạn Brilliant tọa lạc tại một vị trí đắc địa trên đường Bạch Đằng, một trong những con đường đẹp nhất ở trung tâm thành phố Đà Nẵng, nhìn ra sông Hàn tuyệt đẹp với những cây cầu nổi tiếng của nó và một cái nhìn tuyệt vời của một thành phố bên bờ biển.\r\nKể từ khi thành lập vào tháng 11 năm 2012, sau năm năm hoạt động, Brilliant Hotel đã nỗ lực hết sức để cải thiện chất lượng dịch vụ, nhằm đáp ứng tiêu chuẩn 5 sao quốc tế. Ở tại khách sạn Brilliant, khách hàng có cơ hội tận hưởng \"thiên đường trên mặt đất\" với các dịch vụ hạng nhất đã được thực hiện quan tâm đến từng chi tiết, từ dịch vụ thực phẩm và đồ uống, dịch vụ chăm sóc sức khỏe đến dịch vụ hội nghị & tiệc và những thứ khác. Brilliant Hotel Đà Nẵng nhằm mục đích trở thành ngôi nhà thứ hai của bạn trong thành phố xinh đẹp này'),
('ks03', 'Khách sạn RiverSide', '0369559606', 'hieu_1751220089@dau.edu.vn', '30 Trần Hưng Đạo, An Hải Trung, Sơn Trà, Tp Đà Nẵng.', 'https://media-cdn.tripadvisor.com/media/photo-s/13/8e/53/8b/kha-ch-sa-n-da-na-ng.jpg', 'Khách sạn Danang Riverside nằm ở vị trí trung tâm thành phố Đà Nẵng, tọa lạc bên đầu cầu Rồng, đối diện sông Hàn thơ mộng, xinh đẹp, cách sân bay quốc tế Đà Nẵng 02km, đi bộ ra biển Mỹ Khê chỉ 05 phút và đặc biệt là chỉ cách phố cổ Hội An 20km, ngoài ra khách sạn rất gần các trung tâm mua sắm lớn như Vincom, Lotte, Big C... tiện lợi cho quý khách thỏa sức mua sắm.\r\n\r\nĐến với khách sạn của chúng tôi Quý khách sẽ có những ấn tượng khó quên không chỉ bởi vẻ đẹp kiến trúc mà còn bởi sự phục vụ nhiệt tình, chu đáo của đội ngũ nhân viên chuyên nghiệp.\r\n\r\nKhách sạn Danang Riverside đạt tiêu chuẩn bốn sao. Khách sạn có tổng cộng 127 phòng, trong\r\n\r\nđó có 36 phòng Superior, 72 phòng Deluxe City and River, 06 phòng Premium Suite, 13 phòng căn hộ, tất cả các phòng đều rộng rãi, có diện tích từ 28m2– 65m2 và được trang bị đầy đủ các tiện nghi hiện đại.\r\n\r\nHiện tại, khách sạn Danang Riverside có hệ thống nhà hàng nằm trong khu ẩm thực DFC và 06\r\n\r\nphòng hội thảo, đa dạng về kích thước có thể đón số lượng khách lên đến 800 khách, rất tiện lợi và phù hợp cho các chương trình hội nghị, hội thảo cũng như các buổi tiệc chiêu đãi, sự kiện hoặc tiệc cưới.\r\n\r\nBữa sáng miễn phí với thực đơn buffet phong phú, thay đổi theo ngày trong không gian nhà hàng\r\n\r\nOrchid sang trọng. Khách sạn tự hào đáp ứng được mọi nhu cầu của những khách hàng khó tính nhất.\r\n\r\nTại đây, Quý khách sẽ tìm được những món ăn ưa thích trong bất kỳ thời điểm hay sự kiện nào.\r\n\r\nTại Danang Riverside, Quý khách sẽ được tận hưởng những phút giây thư giãn thoải mái khi ngồi thưởng thức những tách cà phê tại nhà hàng Tiamo Lounge được thiết kế đẹp mắt bên bờ sông Hàn trong xanh với Cá chép hóa Rồng, Cầu tình yêu thơ mộng. Đồng thời vào mỗi tối thứ bảy, chủ nhật hàng tuần, từ khách sạn quý khách sẽ được ngắm nhìn cầu Rồng phun lửa, phun nước và luôn được đội ngũ nhân viên của chúng tôi phục vụ tận tình, chu đáo, mang đến cho Quý khách các dịch vụ hạng nhất.Nếu quý khách cần thư giãn, xin hãy ghé thăm phòng chăm sóc sức khỏe, sắc đẹp của khách sạn. Với dịch vụ Spa, nail, phòng tập thể dục, và một bể bơi ngoài trời sẽ mang đến sự hài lòng và thư giãn tốt nhất cho quý khách.'),
('ks04', 'Khách sạn Sun River', '0369559606', 'hieu_1751220089@dau.edu.vn', '132 Bạch Đằng, Hải Châu 1, Hải Châu - Đà Nẵng.', 'https://owa.bestprice.vn/images/hotels/large/khach-san-sun-river-5333e607b55f1-848x477.jpg', 'Khách sạn Sun River tiêu chuẩn 3 sao  tọa lạc tại một vị trí tuyệt đẹp trên con đường Bạch Đằng và Phạm Phú Thứ. Nằm bên bờ sông Hàn thơ mộng và lãng mạn, bạn có thể ngắm nhìn toàn cảnh thành phố biển Đà Nẵng với những cây cầu nổi tiếng rực rỡ ánh sáng nghệ thuật về đêm và bạn thả sức dạo quanh các con phố trung tâm mua sắm, các điểm tham quan nổi tiếng cũng như các trung tâm vui chơi giải trí lớn.'),
('ks05', 'Khách sạn Dana Marian', '0369559606', 'hieu_1751220089@dau.edu.vn', ' 47 Võ Văn Kiệt, P.Phước Mỹ, Q.Sơn Trà, TP.Đà Nẵng', 'https://dulichkhampha24.com/wp-content/uploads/2020/03/khach-san-da-nang-3-sao-gan-trung-tam-5.jpg', 'Dana Marina Hotel Da Nang là khách sạn có dịch vụ quốc tế, có hồ bơi và quầy bar trên tầng thượng, tọa lạc trên đường Võ Văn Kiệt - vị trí thuận tiện và đẹp nhất thành phố Đà Nẵng, nằm gần sát bãi tắm biển Mỹ Khê thơ mộng - nơi đã được tạp chí Forbes của Mỹ bình chọn là một trong những bãi biển đẹp nhất hành tinh, thuận lợi di chuyển đến các điểm tham quan du lịch một cách nhanh chóng. \r\nVới không gian sống cao cấp và sang trọng bao gồm 69 phòng nghỉ đầy đủ tiện nghi, trang thiết bị hiện đại, không gian thân thiện được bài trí trang nhã và ấm áp để quý khách nghỉ ngơi thoải mái.  Khách sạn không chỉ nổi bật với phòng ốc sang trọng, tinh tế trong lối bày trí nội ngoại thất mà còn gây ấn tượng mạnh với quầy Bar nằm cạnh hồ bơi, nằm trên tầng thượng có tầm view lý tưởng, sở hữu không gian thoáng mát, có thể ngắm nhìn toàn cảnh thành phố.\r\nVới tiêu chí sự hài lòng khách hàng là thước đo sự thành công của doanh nghiệp chúng tôi, Dana Marina hotel nơi tôn vinh giá trị đích thực của nghệ thuật phục vụ'),
('ks06', 'Minh Toàn Galaxy Hotel', '0369559606', 'hieu_1751220089@dau.edu.vn', '306 Đường 2/9, P.Hòa Cường Bắc, Q.Hải Châu,Tp.Đà Nẵng', 'http://minhtoangalaxyhotel.vn/files/banners/dji_0011.png', 'Tọa lạc tại vị trí lý tưởng ngay tại trung tâm thành phố Đà Nẵng, Khách sạn Minh Toàn Galaxy với đẳng cấp 4 sao hân hạnh chào đón tất cả quý khách đến với dịch vụ lưu trú hoàn hảo, với cơ sở vật chất hiện đại và các dịch vụ chuyên nghiệp.\r\n \r\nKhách sạn Minh Toàn Galaxy chỉ cách Sân Bay Quốc Tế Đà Nẵng 5 phút di chuyển và gần với các địa điểm nổi tiếng như Cổ Viện Chàm, Chợ Hàn và Biển Mỹ Khê – một trong những bãi biển nổi tiếng nhất thế giới.\r\n \r\nSự hòa quyện giữa kiến trúc Châu Âu và Châu Á khiến Minh Toàn Galaxy là một khách sạn đặc biệt nổi bật giữa thành phố. Tất cả nơi đây được thiết kế trang nhã với tầm nhìn hướng thẳng ra dòng sông Hàn thơ mộng và trung tâm Đà Nẵng. Các phòng lưu trú cũng rất đa dạng, từ các phòng Tiêu chuẩn sang trọng cho đến phòng Tổng Thống mang tầm cỡ quốc tế và chuỗi các căn hộ phù hợp với các chuyến công tác và nghỉ dưỡng. Đặc biệt hơn, hồ bơi ngoài trời cùng với cà phê bar trên tầng thượng là những nơi tuyệt hảo để Quý khách ngắm nhìn toàn cảnh thành phố về đêm trong lúc nhâm nhi một chút thức uống yêu thích.\r\nVà với tiêu chí đẳng cấp quốc tế, Khách sạn Minh Toàn Galaxy cũng trang bị một chuỗi các dịch vụ giải trí, chăm sóc sức khỏe đa dạng từ phòng tập Gym, spa & massage, đến phòng xông hơi và bể sục.\r\n \r\nKhách Sạn Minh Toàn Galaxy còn có chuỗi các phòng hội nghị và hội trường tiệc cưới với sức chứa từ 100 đến 1000 khách cho mỗi phòng. Cùng với đội ngũ nhân viên chuyên nghiệp, nơi đây chính là điểm đến lý tưởng khi Quý khách có nhu cầu về tổ chức hội nghị và sự kiện đẳng cấp. Bên cạnh đó, công nghệ cưới sáng tạo, độc đáo tại Minh Toàn Galaxy sẵn sàng tổ chức các buổi tiệc cưới hoành tráng và khó quên.'),
('ks07', 'Orange Hotel Danang', '0369559606', 'hieu_1751220089@dau.edu.vn', '29 Hoàng Diệu, P.Hải Châu, Q.Hải Châu, TP.Đà Nẵng.', 'https://gotrip.vn/uploads/hotels/577/71075434.jpg', 'Khách sạn Orange nằm trên tuyến đường Hoàng Diệu, địa điểm lý tưởng để du khách có thể đi đến các địa điểm nổi tiếng của TP Đà Nẵng. Khách sạn Orange được xây dựng theo phong cách Châu Âu hiện đại, sang trọng đạt tiêu chuẩn 3 sao, mạng lưới thông tin liên lạc đạt chuẩn quốc tế. Tổng số lượng 45 phòng chia thành 5 kiểu phòng bao gồm Superior, Deluxe, Suite, Executive và phòng Family với cửa thông nhau nội bộ, nội thất tiện nghi sẵn sàng đáp ứng mọi yêu cầu của du khách như đèn đọc sách trên đầu giường, loa nghe nhạc với nút điều khiển âm thanh, truyển hình cáp, bàn làm việc... Với chiều cao 11 tầng, Khu vực Nhà hàng của Khách sạn là vị trí mà du khách có thể phóng tầm nhìn của mình vươn xa để ngắm toàn cảnh thành phố, chụp ảnh, thưởng lãm những cây cầu và dòng sông Hàn bình yên của Đà Nẵng bên cạnh việc thưởng thức các món ăn Âu-Á được đầu bếp của nhà hàng chúng tôi thực hiện. Với tấm lòng và tình cảm của người con xứ Quảng đối với du khách gần xa, nhân viên KS Orange luôn mang đến những dịch vụ tốt nhất đáp ứng mọi nhu cầu của du khách. Khách sạn chúng tôi đã và đang chiếm được nhiều tình cảm của bạn bè trong nước và quốc tế. Hãy đến với Khách sạn Orange, “Sự hài lòng của Quý khách là niềm hạnh phúc của chúng tôi”, chắc chắn bạn sẽ có những kỷ niệm tuyệt vời không thể nào quên trong chuyến hành trình đến với Đà Nẵng- Việt Nam!'),
('ks08', 'Khách sạn Quốc Cường Center', '0369559606', 'hieu_1751220089@dau.edu.vn', '322 Hoàng Diệu, P.Bình Hiên, Q.Hải Châu, TP.Đà Nẵng', 'http://quoccuongcenterhotel.com.vn/wp-content/uploads/2018/03/slide11_v4.jpg', 'Quốc Cường Center Hotel là một trong những khách sạn 4  tọa lạc ngay trung tâm thành phố đà nẵng tại 322- 324 đường Hoàng Diệu, Phường Bình Hiên, Quận Hải Châu, Thành Phố Đà Nẵng. Với vị trí thuận lợi, cách sân bay 1km, Cầu Rồng 1.5km và cách biển Mỹ Khê 3.5 km là địa điểm lý tưởng để nghỉ ngơi cũng như kết hợp cho nhưng chuyến công tác.\r\n\r\nKhách Sạn được thiết kế theo phong cách hiện đại, trang thiết bị bâc nhất với 11 tầng, 140 phòng với không gian rộng rãi, trang thiết bị hiện đai, thiết kế đẹp, lãng mạn với đầy đủ những tiện nghi cao cấp: thang máy, điều hòa nhiệt độ, hệ thống nóng lạnh, bồn tắm, điện thoại, tủ lạnh, tivi màn hình phẳng, truyền hình cáp, Internet cáp quang, Wifi miễn phí,…\r\n\r\nNgoài ra, khách sạn còn cung cấp đa dạng các dịch vụ mang tiêu chuẩn 4  phù hợp cho các chuyến công tác kết hợp nghỉ ngơi gồm: 3 Nhà Hàng (tầng 1, tầng 8, tầng 9), Hồ bơi (tầng 8), sky Bar – pool bar (tầng 8), hội thảo (tầng 8, tầng 9, tầng 11) , Spa- massage- Sauna (tầng 9), Gym(tầng 11)…\r\n\r\nKhách sạn gồm có 5 loại phòng: Suite city view (double/twin/triple), Deluxe river view (double), Deluxe Disable room (twin/double) và Family connecting (double+twin room) hy vọng sẽ mang lại cho quý khách nhiều sự lựa chọn và mong rằng các dịch vụ chất lượng cao, trang thiết bị tiện nghi và đội ngũ nhân viên nhiệt tình, thân thiện sẽ đem lại sự hài lòng cho quý khách khi dừng chân tại Đà Nẵng.'),
('ks09', 'Khách Sạn Phú An', '0369559606', 'hieu_1751220089@dau.edu.vn', '48 2/9, P.Bình Hiên, Q.Hải Châu, Tp.Đà Nẵng.', 'https://d3tosvr3yotk6r.cloudfront.net/Content/UserUploads/Images/Hotels/5/1371/medium_medium_Deluxe%20Twin2%20(1).jpg', 'Khách sạn Phú An chỉ cách Sân Bay Quốc Tế Đà Nẵng 5 phút di chuyển và gần với các địa điểm nổi tiếng như Cổ Viện Chàm, Chợ Hàn và Biển Mỹ Khê – một trong những bãi biển nổi tiếng nhất thế giới.\r\n\r\nĐến với Phú An, bạn sẽ có được tầm nhìn hướng thẳng ra dòng sông Hàn thơ mộng và trung tâm Đà Nẵng, ngắm nhìn cảnh cầu rồng về đêm thật tráng lệ. Đặc biệt hơn, hồ bơi ngoài trời cùng với cà phê bar trên tầng thượng là những nơi tuyệt hảo để Quý khách ngắm nhìn toàn cảnh thành phố về đêm trong lúc nhâm nhi một chút thức uống yêu thích.\r\n\r\nVà với tiêu chí đẳng cấp quốc tế, Khách sạn Phú An cũng trang bị một chuỗi các dịch vụ giải trí, chăm sóc sức khỏe đa dạng từ phòng tập Gym, đến phòng xông hơi.\r\n\r\nKhách Sạn Phú An còn cung cấp dịch vụ phòng hội nghị với sức chứa từ 50 đến 100 khách cho mỗi phòng. Cùng với đội ngũ nhân viên chuyên nghiệp, nơi đây chính là điểm đến lý tưởng khi Quý khách có nhu cầu về tổ chức hội nghị và sự kiện đẳng cấp.\r\n\r\n“Sự hài lòng của bạn là niềm vui của chúng tôi”'),
('ks10', 'Khách Sạn Novotel', '0369559606', 'hieu_1751220089@dau.edu.vn', '36 Bach Dang, P.Hải Chaau1 - Q.Hải Châu, Tp.Đà Nẵng', 'https://cf.bstatic.com/images/hotel/max1024x768/207/207080628.jpg', 'Đà Nẵng là một trong những thành phố sôi động và rực rỡ sắc màu nhất ở Việt Nam. Nơi đây tự hào khi được thiên nhiên ban tặng những bãi biển tuyệt đẹp với bờ cát mịn màng, tinh khôi nằm trải dài; có cảng hàng không Quốc tế hiện đại và nhiều địa điểm văn hóa nổi tiếng nằm trong nội thành, để du khách có thể di chuyển thuận lợi. Chính vì thế, sẽ không có gì đáng ngạc nhiên khi thành phố xinh đẹp này lại thu hút nhiều mối quan tâm, cũng như sự yêu mến nồng hậu của du khách trong nước và quốc tế đến như vậy.\r\n\r\nĐiểm nổi bật của thành phố trẻ đang vươn mình đổi thay từng ngày này – chính là sự giao hòa giữa thiên nhiên yên bình và nhịp sống hiện đại. Nơi đây có đầy đủ cơ sở hạ tầng và nhân lực để hỗ trợ bạn giải quyết vấn đề kinh doanh quan trọng một cách kịp thời, hay tổ chức hội nghị, kế hoạch xúc tiến đầu tư mang tầm vóc quốc tế một cách hiệu quả. Đồng thời vẫn có thể mang đến bạn những phút giây thư thái giữa phong cảnh non nước hữu tình cùng gia đình, bạn bè. Chúng tôi tự hào khi sở hữu đầy đủ những thế mạnh đầy tiềm năng đó tại khách sạn Novotel Danang Premier Han River.\r\n\r\nTọa lạc bên bờ Tây sông Hàn thơ mộng, liền kề với trung tâm hành chính của Đà Nẵng, Novotel sở hữu vị trí đắt địa và nhanh chóng trở thành điểm đến lý tưởng cho các doanh nhân lẫn du khách. Đây là khách sạn đầu tiên đạt tiêu chuẩn quốc tế của thành phố, dưới sự quản lý bởi tập đoàn Accor danh tiếng – nơi luôn đề cao sự phục vụ chuyên nghiệp và giám sát kỹ lưỡng trong mọi dịch vụ tiện ích, nhằm mang đến chất lượng tốt nhất cho du khách. Không những thế, Novotel còn là một trong những khách sạn cao nhất Đà Nẵng, với nhiều điểm đến thú vị như nhà hàng đẳng cấp quốc tế, quầy bar tầng thượng hạng có thể bao quát toàn cảnh thành phố và là khách sạn tiên phong trong dịch vụ căn hộ cao cấp.\r\n\r\nVì vậy, Novotel Danang Premier Han River là lựa chọn hoàn hảo dù bạn đi công tác hay nghỉ dưỡng. Đội ngũ nhân viên chuyên nghiệp và nồng hậu của chúng tôi rất mong được tiếp đón Quý khách.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong`
--

CREATE TABLE `phong` (
  `maphong` char(3) NOT NULL,
  `maks` char(4) NOT NULL,
  `loaiphong` int(1) NOT NULL,
  `vitriphong` int(2) NOT NULL,
  `giaphong` int(11) NOT NULL,
  `trangthai` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phong`
--

INSERT INTO `phong` (`maphong`, `maks`, `loaiphong`, `vitriphong`, `giaphong`, `trangthai`) VALUES
('A01', 'ks01', 2, 1, 800000, '0'),
('A02', 'ks01', 2, 1, 800000, '0'),
('A03', 'ks01', 1, 1, 400000, '1'),
('A04', 'ks01', 1, 1, 400000, '0'),
('A05', 'ks01', 1, 2, 400000, '0'),
('A06', 'ks01', 1, 2, 400000, '0'),
('A07', 'ks01', 2, 2, 800000, '0'),
('A08', 'ks01', 2, 2, 800000, '0'),
('B01', 'ks02', 2, 1, 800000, '0'),
('B02', 'ks02', 2, 1, 800000, '0'),
('B03', 'ks02', 1, 1, 400000, '1'),
('B04', 'ks02', 1, 1, 400000, '0'),
('B05', 'ks02', 1, 2, 400000, '0'),
('B06', 'ks02', 1, 2, 400000, '0'),
('B07', 'ks02', 2, 2, 800000, '0'),
('B08', 'ks02', 2, 2, 800000, '0'),
('C01', 'ks03', 2, 1, 800000, '0'),
('C02', 'ks03', 2, 1, 800000, '0'),
('C03', 'ks03', 1, 1, 400000, '0'),
('C04', 'ks03', 1, 1, 400000, '0'),
('C05', 'ks03', 1, 2, 400000, '0'),
('C06', 'ks03', 1, 2, 400000, '0'),
('C07', 'ks01', 2, 2, 800000, '0'),
('C08', 'ks03', 2, 2, 800000, '0'),
('D01', 'ks04', 1, 1, 400000, '0'),
('D02', 'ks04', 2, 1, 800000, '0'),
('D03', 'ks04', 1, 1, 400000, '0'),
('D04', 'ks03', 1, 1, 400000, '0'),
('D05', 'ks04', 1, 2, 400000, '0'),
('D06', 'ks04', 1, 2, 400000, '0'),
('D07', 'ks04', 2, 2, 800000, '0'),
('D08', 'ks04', 2, 2, 800000, '0'),
('E01', 'ks05', 2, 1, 800000, '0'),
('E02', 'ks05', 2, 1, 800000, '0'),
('E03', 'ks05', 1, 1, 400000, '0'),
('E04', 'ks05', 1, 1, 400000, '0'),
('E05', 'ks05', 1, 2, 400000, '0'),
('E06', 'ks05', 1, 2, 400000, '0'),
('E07', 'ks05', 2, 2, 800000, '0'),
('E08', 'ks05', 2, 2, 800000, '0'),
('F01', 'ks06', 2, 1, 800000, '0'),
('F02', 'ks06', 2, 1, 800000, '0'),
('F03', 'ks06', 1, 1, 400000, '0'),
('F04', 'ks06', 1, 1, 400000, '0'),
('F05', 'ks06', 1, 2, 400000, '0'),
('F06', 'ks06', 1, 2, 400000, '0'),
('F07', 'ks06', 2, 2, 800000, '0'),
('F08', 'ks06', 2, 2, 800000, '0'),
('G01', 'ks07', 2, 1, 800000, '0'),
('G02', 'ks07', 2, 1, 800000, '0'),
('G03', 'ks07', 1, 1, 400000, '1'),
('G04', 'ks07', 1, 1, 400000, '1'),
('G05', 'ks07', 1, 2, 400000, '0'),
('G06', 'ks07', 1, 2, 400000, '0'),
('G07', 'ks07', 2, 2, 800000, '0'),
('G08', 'ks07', 2, 2, 800000, '0'),
('H01', 'ks08', 2, 1, 800000, '0'),
('H02', 'ks08', 2, 1, 800000, '0'),
('H03', 'ks08', 1, 1, 400000, '0'),
('H04', 'ks08', 1, 1, 400000, '0'),
('H05', 'ks08', 1, 2, 400000, '0'),
('H06', 'ks08', 1, 2, 400000, '0'),
('H07', 'ks08', 2, 2, 800000, '0'),
('H08', 'ks08', 2, 2, 800000, '0'),
('I01', 'ks09', 2, 1, 800000, '0'),
('I02', 'ks09', 2, 1, 800000, '0'),
('I03', 'ks09', 1, 1, 400000, '0'),
('I04', 'ks09', 1, 1, 400000, '0'),
('I05', 'ks09', 1, 2, 400000, '0'),
('I06', 'ks09', 1, 2, 400000, '0'),
('I07', 'ks09', 2, 2, 800000, '0'),
('I08', 'ks09', 2, 2, 800000, '0'),
('K01', 'ks10', 2, 1, 800000, '0'),
('K02', 'ks10', 2, 1, 800000, '0'),
('K03', 'ks10', 1, 1, 400000, '0'),
('K04', 'ks10', 1, 1, 400000, '0'),
('K05', 'ks10', 1, 2, 400000, '0'),
('K06', 'ks10', 1, 2, 400000, '0'),
('K07', 'ks10', 2, 2, 800000, '0'),
('K08', 'ks10', 2, 2, 800000, '0');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `datphong`
--
ALTER TABLE `datphong`
  ADD PRIMARY KEY (`madp`),
  ADD KEY `fk_makhachhang` (`makh`),
  ADD KEY `fk_maphong` (`maphong`) USING BTREE;

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `khachsan`
--
ALTER TABLE `khachsan`
  ADD PRIMARY KEY (`maks`);

--
-- Chỉ mục cho bảng `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`maphong`),
  ADD KEY `fk_maks` (`maks`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `datphong`
--
ALTER TABLE `datphong`
  MODIFY `madp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `datphong`
--
ALTER TABLE `datphong`
  ADD CONSTRAINT `fk_makhachhang` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  ADD CONSTRAINT `fk_makhachsan` FOREIGN KEY (`maphong`) REFERENCES `phong` (`maphong`);

--
-- Các ràng buộc cho bảng `phong`
--
ALTER TABLE `phong`
  ADD CONSTRAINT `fk_maks` FOREIGN KEY (`maks`) REFERENCES `khachsan` (`maks`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
