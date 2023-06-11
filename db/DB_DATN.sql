

CREATE DATABASE BANQUANAOTHETHAO
GO

CREATE TABLE SANPHAM(
	ID uniqueidentifier DEFAULT NEWID(),
		MASP NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
)

GO

CREATE TABLE SIZE(
	ID uniqueidentifier DEFAULT NEWID(),
		MASIZE NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	CHIEUCAO NVARCHAR(100),
	CANNANG NVARCHAR(100),
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
)
GO
CREATE TABLE NSX(
	ID uniqueidentifier DEFAULT NEWID(),
		MANSX NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
)
GO

CREATE TABLE DONGSP(
	ID uniqueidentifier DEFAULT NEWID(),
		MADONGSP NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
)
GO

CREATE TABLE MAUSAC(
	ID uniqueidentifier DEFAULT NEWID(),
		MAMAUSAC NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
)
GO

CREATE TABLE CHATLIEU(
	ID uniqueidentifier DEFAULT NEWID(),
		MACHATLIEU NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
)
GO

CREATE TABLE CHITIETSP(
	ID uniqueidentifier DEFAULT NEWID(),
	MACTSP NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	IDSP uniqueidentifier,
	IDDONGSP uniqueidentifier,
	IDMAUSAC uniqueidentifier,
	IDCHATLIEU uniqueidentifier,
	IDSIZE uniqueidentifier,
	IDNSX uniqueidentifier,
	ANH NVARCHAR(255),
	SOLUONGTON INT,
	GIANHAP INT,
	GIABAN INT,
	IMG NVARCHAR(100),
	MAVACH INT,
	MOTA NVARCHAR(255),
	PRIMARY KEY(ID),
	FOREIGN KEY(IDSP) REFERENCES SANPHAM(ID),
	FOREIGN KEY(IDDONGSP) REFERENCES DONGSP(ID),
	FOREIGN KEY(IDMAUSAC) REFERENCES MAUSAC(ID),
	FOREIGN KEY(IDCHATLIEU) REFERENCES CHATLIEU(ID),
	FOREIGN KEY(IDSIZE) REFERENCES SIZE(ID),
	FOREIGN KEY(IDNSX) REFERENCES NSX(ID)
)
GO

CREATE TABLE CHUCVU(
	ID uniqueidentifier DEFAULT NEWID(),
		MACHUCVU NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TEN NVARCHAR(255),
	PRIMARY KEY(ID)
)
GO

CREATE TABLE NHANVIEN(
	ID uniqueidentifier DEFAULT NEWID(),
	MANV NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	CCCD nvarchar(20) unique,
	TEN NVARCHAR(255),
	IDCHUCVU uniqueidentifier,
	GIOITINH BIT,
	NGAYSINH DATE,
	SDT NVARCHAR(10) UNIQUE NOT NULL,
	DIACHI NVARCHAR(255),
	EMAIL NVARCHAR(255) UNIQUE NOT NULL,
	MATKHAU NVARCHAR(255),
	TRANGTHAI BIT,
	PRIMARY KEY(ID),
	FOREIGN KEY(IDCHUCVU) REFERENCES CHUCVU(ID)
)
GO

CREATE TABLE KHUYENMAI(
	ID uniqueidentifier DEFAULT NEWID(),
	MAKHUYENMAI NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TEN NVARCHAR(255),
	MUCGIAMGIA INT,
	NGAYBATDAU DATETIME,
	NGAYKETTHUC DATETIME,
	TRANGTHAI INT,
	PRIMARY KEY(ID)
)
GO


CREATE TABLE KHACHHANG(
	ID uniqueidentifier DEFAULT NEWID(),
	MAKHACHHANG NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	CCCD NVARCHAR(20) ,
	TEN NVARCHAR(255),
	SDT NVARCHAR(10),
	CAPBAC INT,
	DIACHI NVARCHAR(255),
	PRIMARY KEY(ID)
)
GO 
CREATE TABLE HOADON(
	ID uniqueidentifier DEFAULT NEWID(),
	MAHOADON NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	IDNHANVIEN uniqueidentifier,
	IDKHACHHANG uniqueidentifier,
	SDT NVARCHAR(10) DEFAULT N'Không có',
	DIACHI NVARCHAR(255),
	HINHTHUCTHANHTOAN INT DEFAULT 0,
	LYDO NVARCHAR(255) DEFAULT N'Không có',
	NGAYTHANHTOAN DATE,
	TIENKHACHTRA INT DEFAULT 0,
	TIENKHACHCHUYENKHOAN INT DEFAULT 0,
	TRANGTHAI INT DEFAULT 0,
	TONGTIEN INT DEFAULT 0,
	IDKHUYENMAI uniqueidentifier,
	TIENSAUGIAMGIA INT DEFAULT 0,
	PRIMARY KEY(ID),
	FOREIGN KEY(IDNHANVIEN) REFERENCES NHANVIEN(ID),
	FOREIGN KEY(IDKHUYENMAI) REFERENCES KHUYENMAI(ID),
	FOREIGN KEY(IDKHACHHANG) REFERENCES KHACHHANG(ID)
)
GO

CREATE TABLE HOADONCHITIET(
	ID uniqueidentifier DEFAULT NEWID(),
	IDHOADON uniqueidentifier,
	IDCTSP uniqueidentifier,
		MAHOADONCHITIET NVARCHAR(20) UNIQUE,
		NGAYTAO DATE,
	NGAYSUA DATE,
	TENSP NVARCHAR(255),
	TENNSX NVARCHAR(255),
	DONGSP NVARCHAR(255),
	MAUSAC NVARCHAR(255),
	ANH NVARCHAR(255),
	SIZE NVARCHAR(255),
	SOLUONG INT,
	DONGIA INT,
	TRANGTHAI INT DEFAULT 0,
	PRIMARY KEY(ID),
	FOREIGN KEY(IDHOADON) REFERENCES HOADON(ID),
	FOREIGN KEY(IDCTSP) REFERENCES CHITIETSP(ID)
)
GO
