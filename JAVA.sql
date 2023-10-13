Create database BCCD_JAVA
use BCCD_JAVA
Create table TacGia(
	MaTacGia nvarchar(50) primary key,
	TenTongChuBien nvarchar(50),
	TenPhoChuBien nvarchar(50),
	LienHe nvarchar(50)
);

Create table TheLoai(
	MaTheLoai nvarchar(50) primary key,
	TenTheLoai nvarchar(50),
	Khoi nvarchar(50),
);

Create table NhaXuatBan(
	MaNhaXuatBan nvarchar(50) primary key,
	TenNhaXuatBan nvarchar(50),
	DiaChi nvarchar(50),
	DienThoai nvarchar(50)
);

Create Table Sach(
	MaSach nvarchar(50),
	TenSach nvarchar(50),
	SoLuongTon int,
	MaTheLoai nvarchar(50),
	MaNhaXuatBan nvarchar(50),
	MaTacGia nvarchar(50),
	XuatBanLanThu int,
	GiaNhap float,
	BiaSach	image,
	GiaBan float,

	Primary key(MaSach),
	FOREIGN KEY (MaNhaXuatBan) REFERENCES NhaXuatBan(MaNhaXuatBan),
	FOREIGN KEY (MaTacGia) REFERENCES TacGia(MaTacGia),
	FOREIGN KEY (MaTheLoai) REFERENCES TheLoai(MaTheLoai),
);
drop table Sach

Create table Nguoidung(
	Taikhoan nvarchar(50) not null,
	Matkhau	nvarchar(50) not null
);

Create Table NhanVien(
	MaNV nvarchar(50) primary key,
	HoTen nvarchar(50),
	SoDienThoai nvarchar(50),
	GioiTinh nvarchar(50),
	NgaySinh date,
	QueQuan nvarchar(50),
	DiaChiHienTai nvarchar(50),
	HeSoLuong float,
	AnhCaNhan varbinary(MAX)
);
drop table NhanVien

CREATE TABLE Luong (
    MaNV NVARCHAR(50),
    Thang INT,
    SoCong FLOAT,
    Thuong FLOAT,
    Phat FLOAT,
    TongLuong FLOAT,
	primary key(MaNV, Thang),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
);
drop table Luong

create table HoaDonBan(
	MaHoaDonBan nvarchar(50) primary key,
	NgayBan date,
	TongThanhToanHoaDon float,
);

create table HoaDonNhap(
	MaHoaDonNhap nvarchar(50) primary key,
	NgayNhap date,
	TongThanhToanHoaDon float,
);

drop table HoaDonBan
drop table HoaDonNhap

create table CTHDB(
	MaHoaDonBan nvarchar(50),
	MaSach nvarchar(50),
	SoLuong int
	primary key(MaHoaDonBan, MaSach),
	foreign key (MaHoaDonBan) references HoaDonBan(MaHoaDonBan),
	foreign key (MaSach) references Sach(MaSach)
);

create table CTHDN(
	MaHoaDonNhap nvarchar(50),
	MaSach nvarchar(50),
	SoLuong int
	primary key(MaHoaDonNhap, MaSach),
	foreign key (MaHoaDonNhap) references HoaDonNhap(MaHoaDonNhap),
	foreign key (MaSach) references Sach(MaSach)
);
drop table CTHDN
drop table CTHDB

insert into NguoiDung values ('quanly','123')
insert into NguoiDung values ('thuhuyen','294')
insert into NhaXuatBan values ('NXB01', N'Nhà xuất bản Giáo dục Việt Nam (NEV)', N'Hà Nội', '0123')
insert into TacGia values ('TG01',N'Nguyễn Văn A', N'Trần Thị B','0123')
insert into TheLoai values ('TL01', N'Tiếng Việt 10','10')

Insert into Sach values ('S01', N'Toán Học 10', 10, 'TL01', 'NXB01', 'TG01', 1, 
(SELECT BulkColumn FROM OPENROWSET(BULK 'D:\testjava\LUFJ8595.JPG', SINGLE_BLOB) AS Picture))
Insert into Sach values ('S02', 'Toán Học 10', 10, 'TL01', 'NXB01', 'TG01', 1, 
(SELECT BulkColumn FROM OPENROWSET(BULK 'C:\anhbia\toan10.jpg', SINGLE_BLOB) AS Picture))

-- ================================================
-- Template generated from Template Explorer using:
-- Create Trigger (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- See additional Create Trigger templates for more
-- examples of different Trigger statements.
--
-- This block of comments will not be included in
-- the definition of the function.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================

CREATE TRIGGER Trig_TinhLuong 
   ON  Luong
   AFTER INSERT, UPDATE
AS 
BEGIN
	update Luong
	set TongLuong = ((select HeSoLuong from NhanVien where NhanVien.MaNV = Luong.MaNV) 
	* (select SoCong from inserted where MaNV = Luong.MaNV)) 
	+ (select Thuong from inserted where MaNV = Luong.MaNV) 
	- ( select Phat from inserted where MaNV = Luong.MaNV)
	from inserted
	where Luong.MaNV = inserted.MaNV and Luong.Thang = inserted.Thang
END
GO

drop trigger Trig_TinhLuong

CREATE TRIGGER Trig_Tinhgiaban
	ON Sach
	AFTER INSERT, UPDATE 
AS 
BEGIN
    UPDATE Sach
    SET GiaBan = inserted.GiaNhap*1.3 From inserted
    where Sach.MaSach = inserted.MaSach
END
GO

drop trigger Trig_Tinhgiaban

CREATE TRIGGER trg_tinhthanhtoan
ON CTHDN
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    UPDATE HoaDonNhap
    SET TongThanhToanHoaDon = (
        SELECT SUM(Sach.GiaNhap * CTHDN.SoLuong) 
        FROM CTHDN 
        INNER JOIN Sach ON CTHDN.MaSach = Sach.MaSach
        WHERE CTHDN.MaHoaDonNhap = HoaDonNhap.MaHoaDonNhap
    )
    WHERE HoaDonNhap.MaHoaDonNhap IN (
        SELECT MaHoaDonNhap FROM inserted
        UNION SELECT MaHoaDonNhap FROM deleted
    )
END

CREATE TRIGGER trg_tinhthanhtoanban
ON CTHDB
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    UPDATE HoaDonBan
    SET TongThanhToanHoaDon = (
        SELECT SUM(Sach.GiaBan * CTHDB.SoLuong) 
        FROM CTHDB 
        INNER JOIN Sach ON CTHDB.MaSach = Sach.MaSach
        WHERE CTHDB.MaHoaDonBan = HoaDonBan.MaHoaDonBan
    )
    WHERE HoaDonBan.MaHoaDonBan IN (
        SELECT MaHoaDonBan FROM inserted
        UNION SELECT MaHoaDonBan FROM deleted
    )
END

CREATE TRIGGER trg_soluongton_CTHDN
ON CTHDN
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    UPDATE Sach
    SET SoLuongTon = SoLuongTon + (SELECT SUM(IIF(d.Type = 'D', -d.SoLuong, d.SoLuong))
                                   FROM (SELECT 'D' AS Type, deleted.MaSach, deleted.SoLuong FROM deleted
                                         UNION ALL
                                         SELECT 'I' AS Type, inserted.MaSach, inserted.SoLuong FROM inserted) d
                                   WHERE d.MaSach = Sach.MaSach)
    FROM Sach
    WHERE EXISTS (SELECT *
                  FROM inserted
                  WHERE inserted.MaSach = Sach.MaSach
                 )
           OR EXISTS (SELECT *
                      FROM deleted
                      WHERE deleted.MaSach = Sach.MaSach
                     );
END

CREATE TRIGGER trg_soluongton_CTHDB
ON CTHDB
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    UPDATE Sach
    SET SoLuongTon = SoLuongTon - (SELECT SUM(IIF(d.Type = 'D', -d.SoLuong, d.SoLuong))
                                   FROM (SELECT 'D' AS Type, deleted.MaSach, deleted.SoLuong FROM deleted
                                         UNION ALL
                                         SELECT 'I' AS Type, inserted.MaSach, inserted.SoLuong FROM inserted) d
                                   WHERE d.MaSach = Sach.MaSach)
    FROM Sach
    WHERE EXISTS (SELECT *
                  FROM inserted
                  WHERE inserted.MaSach = Sach.MaSach
                 )
           OR EXISTS (SELECT *
                      FROM deleted
                      WHERE deleted.MaSach = Sach.MaSach
                     );
END
