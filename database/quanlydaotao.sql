
USE [quanlydaotao]
GO

CREATE TABLE students (
    id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    student_code NVARCHAR(50) NOT NULL UNIQUE,
    full_name NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL UNIQUE,
    phone NVARCHAR(20) NOT NULL,
    class_name NVARCHAR(100) NOT NULL
);
GO
INSERT INTO students (id, student_code, full_name, email, phone, class_name)
VALUES
    (NEWID(), 'SV001', N'Nguyễn Văn A', 'a@gmail.com', '0901234567', 'C2024A'),
    (NEWID(), 'SV002', N'Trần Thị B', 'b@gmail.com', '0912345678', 'C2024B'),
    (NEWID(), 'SV003', N'Lê Hoàng C', 'c@gmail.com', '0923456789', 'C2024C'),
    (NEWID(), 'SV004', N'Phạm Minh D', 'd@gmail.com', '0933456789', 'C2024A'),
    (NEWID(), 'SV005', N'Hoàng Thị E', 'e@gmail.com', '0944567890', 'C2024B'),
    (NEWID(), 'SV006', N'Vũ Đức F', 'f@gmail.com', '0955678901', 'C2024C'),
    (NEWID(), 'SV007', N'Đặng Nhật G', 'g@gmail.com', '0966789012', 'C2024A'),
    (NEWID(), 'SV008', N'Bùi Thảo H', 'h@gmail.com', '0977890123', 'C2024B'),
    (NEWID(), 'SV009', N'Ngô Quốc I', 'i@gmail.com', '0988901234', 'C2024C'),
    (NEWID(), 'SV010', N'Mai Lan K', 'k@gmail.com', '0999012345', 'C2024A');
GO