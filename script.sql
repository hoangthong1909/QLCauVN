create table ChuDauTu
(
    id        int auto_increment
        primary key,
    HoTen     varchar(100) charset utf8 null,
    sdt       varchar(15) charset utf8  null,
    gioiTinh  bit                       not null,
    email     varchar(50) charset utf8  null,
    trangThai bit                       not null,
    cmnd      varchar(50)               not null,
    diaChi    varchar(200) charset utf8 not null
);

create table DonViGiamSat
(
    id       int auto_increment
        primary key,
    TenDonVi varchar(50) charset utf8 null
);

create table DonViQuanLy
(
    id       int auto_increment
        primary key,
    TenDonVi varchar(50) charset utf8 null
);

create table DonViThiCong
(
    id       int auto_increment
        primary key,
    TenDonVi varchar(50) charset utf8 null
);

create table DonViThietKe
(
    id       int auto_increment
        primary key,
    TenDonVi varchar(50) charset utf8 null
);

create table QuocLo
(
    id        int auto_increment
        primary key,
    TenQuocLo varchar(50) charset utf8 null
);

create table Tinh
(
    id      int auto_increment
        primary key,
    TenTinh varchar(50) charset utf8 null
);

create table Huyen
(
    id       int auto_increment
        primary key,
    TenHuyen varchar(50) charset utf8 null,
    idTinh   int                      null,
    constraint Huyen_Tinh_id_fk
        foreign key (idTinh) references Tinh (id)
);

create table TinhTrang
(
    id           int auto_increment
        primary key,
    TenTinhTrang varchar(50) charset utf8 null
);

create table ViTriXa
(
    id      int auto_increment
        primary key,
    TenXa   varchar(50) charset utf8 null,
    idHuyen int                      null,
    constraint ViTriXa_Huyen_id_fk
        foreign key (idHuyen) references Huyen (id)
);

create table Cau
(
    id             int auto_increment
        primary key,
    TenCau         varchar(50) charset utf8 null,
    namXD          date                     null,
    namHT          date                     null,
    namKT          date                     null,
    TongMucDauTu   double                   null,
    TaiTrongTK     double                   null,
    idChuDauTu     int                      null,
    idDonViThiCong int                      null,
    idDonViThietKe int                      null,
    idDonViGiamSat int                      null,
    idDonViQuanLy  int                      null,
    IdQuocLo       int                      null,
    idViTri        int                      null,
    idTinhTrang    int                      null,
    trangThai      int                      not null,
    dateUpdate     date                     null,
    dateCreate     date                     not null,
    constraint Cau_ChuDauTu_id_fk
        foreign key (idChuDauTu) references ChuDauTu (id),
    constraint Cau_DonViGiamSat_id_fk
        foreign key (idDonViGiamSat) references DonViGiamSat (id),
    constraint Cau_DonViQuanLy_id_fk
        foreign key (idDonViQuanLy) references DonViQuanLy (id),
    constraint Cau_DonViThiCong_id_fk
        foreign key (idDonViThiCong) references DonViThiCong (id),
    constraint Cau_DonViThietKe_id_fk
        foreign key (idDonViThietKe) references DonViThietKe (id),
    constraint Cau_QuocLo_id_fk
        foreign key (IdQuocLo) references QuocLo (id),
    constraint Cau_TinhTrang_id_fk
        foreign key (idTinhTrang) references TinhTrang (id),
    constraint Cau_ViTriXa_id_fk
        foreign key (idViTri) references ViTriXa (id)
);


