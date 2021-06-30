create Database QuanLyDoAnNhanh
use QuanLyDoAnNhanh
go
CREATE TABLE [dbo].[HoaDonNhap](
	[MaHDN] [char](10) NOT NULL,
	[MaNCC] [char](10) NULL,
	[MaSP] [char](10) NULL,
	[SoLuong] [int] NULL,
	[GiaNhap] [decimal](18, 0) NULL,
	[ThanhTien] [decimal](18, 0) NULL,
	[NgayNhap] [date] NULL,
 CONSTRAINT [PK_HoaDonNhap] PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
go
CREATE TABLE [dbo].[HoaDonXuat](
	[MaHDX] [char](10) NOT NULL,
	[MaKH] [char](10) NULL,
	[MaSP] [char](10) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [decimal](18, 0) NULL,
	[NgayXuat] [date] NULL,
	[ThanhTien] [decimal](18, 0) NULL,
 CONSTRAINT [PK_HoaDonXuat] PRIMARY KEY CLUSTERED 
(
	[MaHDX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
go
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [char](10) NOT NULL,
	[TenKH] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](500) NULL,
	[SoDienThoai] [varchar](20) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [char](10) NOT NULL,
	[TenNhaCC] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SoDienThoai] [varchar](20) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenTaiKhoan] [char](100) PRIMARY KEY NOT NULL,
	[MatKhau] [char](100) NULL,
	[TenNguoiDung] [nvarchar](100) NULL,
	[GioiTinh] [bit] NULL,
	[SoDienThoai] [varchar](20) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Quyen] [bit] null
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [char](10) NOT NULL,
	[TenSP] [nvarchar](100) NULL,
	[MaNCC] [char](10) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [decimal](18, 0) NULL,
	[HanSD] [date] NULL,
	[NgaySX] [date] NULL,
	[GhiChu] [text] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO


CREATE TABLE DanhGia(
 TenTaiKhoan char(100) not null,
 NgayHoi date not null,
 NoiDungHoi nvarchar(3000) not null
	)
GO
CREATE TABLE GoiMon(
 MaSP char(10) primary key not null,
 TenSP nvarchar(100) not null,
 NgayGoi date not null,
	)
GO


ALTER TABLE [dbo].[HoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhap_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[HoaDonNhap] CHECK CONSTRAINT [FK_HoaDonNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[HoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonNhap_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[HoaDonNhap] CHECK CONSTRAINT [FK_HoaDonNhap_SanPham]
GO
ALTER TABLE [dbo].[HoaDonXuat]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonXuat_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDonXuat] CHECK CONSTRAINT [FK_HoaDonXuat_KhachHang]
GO
ALTER TABLE [dbo].[HoaDonXuat]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonXuat_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[HoaDonXuat] CHECK CONSTRAINT [FK_HoaDonXuat_SanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[DanhGia]  WITH CHECK ADD  CONSTRAINT [FK_DanhGia_TaiKhoan] FOREIGN KEY([TenTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([TenTaiKhoan])
GO
ALTER TABLE [dbo].[GoiMon]  WITH CHECK ADD  CONSTRAINT [FK_GoiMon_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_GoiMon_SanPham]
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_DanhGia_TaiKhoan]
GO


CREATE proc [dbo].[sp_AllHDN]
as
SELECT        HoaDonNhap.MaHDN, NhaCungCap.TenNhaCC, SanPham.TenSP, HoaDonNhap.SoLuong, HoaDonNhap.GiaNhap, HoaDonNhap.ThanhTien, HoaDonNhap.NgayNhap
FROM            HoaDonNhap INNER JOIN
                         NhaCungCap ON HoaDonNhap.MaNCC = NhaCungCap.MaNCC INNER JOIN
                         SanPham ON HoaDonNhap.MaSP = SanPham.MaSP


go
CREATE proc [dbo].[sp_AllHDX]
as
SELECT        HoaDonXuat.MaHDX, KhachHang.TenKH, SanPham.TenSP, HoaDonXuat.SoLuong, HoaDonXuat.DonGia, HoaDonXuat.ThanhTien, HoaDonXuat.NgayXuat
FROM            HoaDonXuat INNER JOIN
                         KhachHang ON HoaDonXuat.MaKH = KhachHang.MaKH INNER JOIN
                         SanPham ON HoaDonXuat.MaSP = SanPham.MaSP
GO
--xử lý số lượng xuất
create trigger Xuat
on HoaDonXuat
for insert
as
begin
if(not exists(select*from SanPham inner join 
inserted
         on SanPham.MaSP=inserted.MaSP))
		 begin
		   Raiserror(' Loi Khong co hang',16,1)
		   rollback tran
		 end
		 else
		 begin
		 declare @soluong int
		 declare @soluongX int
		 select @soluong=SanPham.SoLuong from SanPham inner join inserted on SanPham.MaSP=inserted.MaSP
		 select @soluongX=inserted.SoLuong from inserted
		 if(@soluong<@soluongX)
		 begin
		     raiserror('Ban khong du hang de xuat',16,1)
			 rollback tran
		 end
		 else
		     
			 update SanPham set SanPham.SoLuong=SanPham.SoLuong-@soluongX
			 from SanPham inner join inserted on SanPham.MaSP=inserted.MaSP
		 end
		 end

go
--Xử lí số lượng nhập
create trigger Nhap
on HoaDonNhap
for insert
as
begin
if(not exists(select*from SanPham inner join 
inserted
         on SanPham.MaSP=inserted.MaSP))
		 begin
		   Raiserror(' Loi Khong co hang',16,1)
		   rollback tran
		 end
		 else
		 begin
		 declare @soluong int
		 declare @soluongN int
		 select @soluong=SanPham.SoLuong from SanPham inner join inserted on SanPham.MaSP=inserted.MaSP
		 select @soluongN=inserted.SoLuong from inserted
	
			 update SanPham set SanPham.SoLuong=SanPham.SoLuong+@soluongN
			 from SanPham inner join inserted on SanPham.MaSP=inserted.MaSP
		 end
		 end
go
--- xu li update Hoa Don X

create trigger SuaX
on HoaDonXuat
for update
as
begin

		 
		 declare @soluong int
		 declare @soluongX int 
		set @soluong=(select SoLuong from deleted)
		set @soluongX=(select SoLuong from inserted)
		update SanPham set SoLuong=SoLuong-(@soluongX-@soluong)
		 end

go
create trigger XoaN
on HoaDonNhap
for delete
as
begin
if(not exists(select*from SanPham inner join 
deleted
         on SanPham.MaSP=deleted.MaSP))
		 begin
		   Raiserror(' Loi Khong co hang',16,1)
		   rollback tran
		 end
		 else
		 begin
		 declare @soluong int
		 declare @soluongN int
		 select @soluong=SanPham.SoLuong from SanPham inner join deleted on SanPham.MaSP=deleted.MaSP
		 select @soluongN=deleted.SoLuong from deleted
		 if(@soluong<@soluongN)
		 begin
		     raiserror('Ban khong du hang de xuat',16,1)
			 rollback transaction
		 end
		 else
		     
			 update SanPham set SanPham.SoLuong=SanPham.SoLuong-@soluongN
			 from SanPham inner join deleted on SanPham.MaSP=deleted.MaSP
		 end
		 end
go
create trigger SuaN
on HoaDonNhap
for update
as
begin 
		 declare @soluong int
		 declare @soluongN int 
		 set @soluong=(select SoLuong from deleted)
		 set @soluongN=(select SoLuong from inserted)
		update SanPham set SoLuong=SoLuong+(@soluongN-@soluong)
		 end
		

go

/*create trigger XoaN
on HoaDonNhap
after delete
as
begin
 declare @MaHDN char(10)

 declare @MaNCC char(10)
 declare @MaSP char(10)
 declare @SoLuong int
 declare @GiaNhap decimal(18,0)
 declare @ThanhTien decimal(18,0)
 declare @NgayNhap date
 select @MaHDN=MaHDN,@MaNCC=MaNCC,@MaSP=MaSP,@SoLuong=SoLuong,@GiaNhap=GiaNhap,@ThanhTien=ThanhTien,@NgayNhap=NgayNhap from deleted
 insert into SanPham values(@MaSP,@TenSP,@MaNCC,@SoLuong,@DonGia,@ThanhT,'cc')

end*/

----
go
create trigger XoaX
on HoaDonXuat
for delete
as
begin
if(not exists(select*from SanPham inner join 
deleted
         on SanPham.MaSP=deleted.MaSP))
		 begin
		   Raiserror(' Loi Khong co hang',16,1)
		   rollback tran
		 end
		 else
		 begin
		 declare @soluong int
		 declare @soluongX int
		 select @soluong=SanPham.SoLuong from SanPham inner join deleted on SanPham.MaSP=deleted.MaSP
		 select @soluongX=deleted.SoLuong from deleted
		 if(@soluong<@soluongX)
		 begin
		     raiserror('Ban khong du hang de xuat',16,1)
			 rollback transaction
		 end
		 else
		     
			 update SanPham set SanPham.SoLuong=SanPham.SoLuong+@soluongX
			 from SanPham inner join deleted on SanPham.MaSP=deleted.MaSP
		 end
		 end
go
select *from SanPham
select *from TaiKhoan
select *from NhaCungCap
select *from DanhGia
select *from GoiMon
select *from HoaDonNhap
select *from HoaDonXuat
select *from KhachHang

delete TaiKhoan where TenTaiKhoan='Hang'
delete NhaCungCap where MaNCC='ncc6'
delete HoaDonNhap where MaNCC='hdx1'



--Nhà cung cấp--
insert into NhaCungCap values('ncc2','Nutifood',N'Bắc Từ Liêm - Hà Nội','01252483')
insert into NhaCungCap values('ncc3','Cung đình',N'Cầu Giấy - Hà Nội','0125452783')
insert into NhaCungCap values('ncc4','Đức Hạnh',N'Nam Từ Liêm- Hà Nội','0125226585')
insert into NhaCungCap values('ncc5','Tràng An',N'Lục Ngạn - Bắc Giang','025498793')
