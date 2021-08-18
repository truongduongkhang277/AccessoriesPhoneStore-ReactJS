-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2021 at 03:22 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accessoriesstoredb`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `name`) VALUES
(1, 'Samsung'),
(2, 'Apple'),
(3, 'Oppo'),
(4, 'Anker'),
(5, 'Sony'),
(6, 'Xiaomi');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(8, 'Ốp lưng'),
(9, 'Cáp điện thoại'),
(10, 'Adapter sạc, chuyển đổi'),
(11, 'Sạc dự phòng'),
(12, 'Tai nghe');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `order_item_id` int(11) NOT NULL,
  `shipping_address_id` int(11) NOT NULL,
  `payment_method_id` int(11) NOT NULL,
  `item_price` int(11) NOT NULL,
  `shipping_price` int(11) NOT NULL,
  `tax_price` int(11) NOT NULL,
  `total_price` int(11) NOT NULL,
  `is_paid` tinyint(1) NOT NULL,
  `paid_at` date NOT NULL,
  `is_delivered` tinyint(1) NOT NULL,
  `delivered_at` date NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `order_item_id`, `shipping_address_id`, `payment_method_id`, `item_price`, `shipping_price`, `tax_price`, `total_price`, `is_paid`, `paid_at`, `is_delivered`, `delivered_at`, `user_id`) VALUES
(1, 1, 1, 1, 150000, 10000, 15000, 175000, 1, '2021-08-18', 1, '2021-08-18', 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `order_items`
--

INSERT INTO `order_items` (`id`, `name`, `quantity`, `image`, `price`, `product_id`) VALUES
(1, 'Ốp lưng iPhone 12 Mini nhựa dẻo', 1, 'https://cdn.tgdd.vn/Products/Images/60/233590/op-iphone-12-mini-deo-matte-imd-wave-ck-sc20164-1-1-600x600.jpg', 150000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`id`, `name`) VALUES
(1, 'Thanh toán khi nhận hàng'),
(2, 'Thanh toán qua thẻ');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `cost` float NOT NULL,
  `price` float DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `count_in_stock` int(11) NOT NULL,
  `rating` float NOT NULL,
  `num_reviews` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `brand_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `cost`, `price`, `image`, `count_in_stock`, `rating`, `num_reviews`, `description`, `brand_id`, `category_id`) VALUES
(2, 'Ốp lưng Iphone 12 Mini Nhựa dẻo', 75000, 150000, 'https://cdn.tgdd.vn/Products/Images/60/233590/op-iphone-12-mini-deo-matte-imd-wave-ck-sc20164-1-1-600x600.jpg', 10, 4, 2, 'Ốp lưng iPhone 12 Mini nhựa dẻo Matte IMD Wave OSMIA CK-SC20164 Gấu', 2, 8),
(3, 'Ốp lưng Iphone 12/12 Pro Nhựa cứng viền dẻo', 75000, 150000, 'https://cdn.tgdd.vn/Products/Images/60/233601/op-lung-iphone-12-12-pro-nhua-cung-vien-deo-temper-1-600x600.jpg', 10, 4.5, 1, '2021-08-18', 2, 8),
(4, 'Ốp lưng Iphone 12 Pro Max Da Apple', 1250000, 1790000, 'https://cdn.tgdd.vn/Products/Images/60/237539/op-lung-iphone-12-pro-max-da-apple-mhkm3-den-ava-600x600.jpg', 10, 5, 1, '2021-08-18', 2, 8),
(5, 'Ốp lưng Iphone 11 Nhựa cứng viền dẻo', 100000, 200000, 'https://cdn.tgdd.vn/Products/Images/60/218621/op-lung-iphone-11-nhua-cung-vien-deo-pu-candy-osmi-1-600x600.jpg', 10, 4, 1, '2021-08-18', 2, 8),
(6, 'Ốp lưng Iphone 11 Pro Nhựa cứng viền dẻo', 100000, 200000, 'https://cdn.tgdd.vn/Products/Images/60/218543/op-lung-iphone-11-pro-nhua-cung-candy-osmia-hong-1-600x600.jpg', 10, 4, 1, '2021-08-18', 2, 8),
(7, 'Ốp lưng Iphone 11 Pro Max Nhựa dẻo', 75000, 150000, 'https://cdn.tgdd.vn/Products/Images/60/223001/op-lung-iphone-11-pro-max-deo-joint-pu-case-den-1-600x600.jpg', 10, 4.5, 2, '2021-08-18', 2, 8),
(8, 'Ốp lưng Iphone XS Max Nhựa cứng viền dẻo', 100000, 200000, 'https://cdn.tgdd.vn/Products/Images/60/218529/op-lung-iphone-xs-max-nhua-cung-vien-deo-tempered-1-600x600.jpg', 10, 3.5, 2, '2021-08-18', 2, 8),
(9, 'Ốp lưng Iphone X/XS Nhựa cứng viền dẻo', 100000, 200000, 'https://cdn.tgdd.vn/Products/Images/60/218520/op-lung-iphone-x-xs-nhua-cung-vien-deo-pu-candy-os-1-600x600.jpg', 10, 4, 4, '2021-08-18', 2, 8),
(10, 'Ốp lưng Iphone XR  Nhựa dẻo', 100000, 200000, 'https://cdn.tgdd.vn/Products/Images/60/194179/op-lung-iphone-xr-deo-glass-duo-jm-den-1-600x600.jpg', 10, 5, 2, '2021-08-18', 2, 8),
(11, 'Ốp lưng Iphone 7 Plus/ 8 Plus Nhựa dẻo', 60000, 120000, 'https://cdn.tgdd.vn/Products/Images/60/221588/op-lung-iphone-7-8-plus-deo-beckman-jm-tpu-den-1-600x600.jpg', 10, 4.5, 10, '2021-08-18', 2, 8),
(12, 'Ốp lưng Iphone 7/8  Nhựa dẻo', 50000, 100000, 'https://cdn.tgdd.vn/Products/Images/60/218628/op-lung-iphone-7-8-nhua-deo-figure-tpu-case-cosano-1-600x600.jpg', 10, 3.5, 7, '2021-08-18', 2, 8),
(13, 'Ốp lưng Galaxy A71 Nhựa dẻo', 75000, 150000, 'https://cdn.tgdd.vn/Products/Images/60/223000/op-lung-galaxy-a71-deo-morie-pu-case-cosano-xam-1-600x600.jpg', 10, 4.5, 1, '2021-08-17', 1, 8),
(14, 'Ốp lưng Galaxy A51/A31 Nhựa cứng viền dẻo', 100000, 200000, 'https://cdn.tgdd.vn/Products/Images/60/224903/op-lung-galaxy-a51-a31-cung-vien-deo-flip-iv-den-1-600x600.jpg', 10, 4, 2, '2021-08-17', 1, 8),
(15, 'Bao da Galaxy S20 Nắp gập', 750000, 900000, 'https://cdn.tgdd.vn/Products/Images/60/219038/bao-da-galaxy-s20-nap-gap-clear-view-samsung-hong-ava-600x600.jpg', 10, 5, 4, '2021-08-17', 1, 8),
(16, 'Bao da Galaxy S20+ Nắp gập', 800000, 1100000, 'https://cdn.tgdd.vn/Products/Images/60/219054/bao-da-galaxy-s20-plus-led-view-cover-samsung-den-ava-600x600.jpg', 10, 5, 1, '2021-08-17', 1, 8),
(17, 'Ốp lưng Galaxy A50/A50S Nhựa dẻo', 50000, 100000, 'https://cdn.tgdd.vn/Products/Images/60/214433/op-galaxy-a50-a50s-deo-electroplate-t-b-osmia-gold-1-600x600.jpg', 10, 4, 2, '2021-08-17', 1, 8),
(18, 'Ốp lưng Galaxy Note 20 Ultra Nhựa dẻo', 150000, 300000, 'https://cdn.tgdd.vn/Products/Images/60/229501/op-galaxy-note-20-ultra-deo-liquid-silicone-hong-1-600x600.jpg', 10, 4.5, 15, '2021-08-17', 1, 8),
(19, 'Ốp lưng Galaxy A20S Nhựa dẻo', 50000, 100000, 'https://cdn.tgdd.vn/Products/Images/60/222954/op-lung-galaxy-a20s-nhua-deo-auto-focus-tpu-cosano-1-600x600.jpg', 10, 4.5, 1, '2021-08-17', 1, 8),
(20, 'Ốp lưng Oppo A9 Nhựa dẻo', 50000, 100000, 'https://cdn.tgdd.vn/Products/Images/60/214453/op-lung-oppo-a9-deo-new-jelly-tks-511-meeker-den-1-600x600.jpg', 10, 4.5, 1, '2021-08-16', 3, 8),
(21, 'Ốp lưng Oppo Reno2 F Nhựa dẻo', 75000, 150000, 'https://cdn.tgdd.vn/Products/Images/60/214484/op-lung-oppo-reno2-f-deo-paint-anti-shock-silver-1-600x600.jpg', 10, 4, 3, '2021-08-16', 3, 8),
(22, 'Ốp lưng Oppo A91 Nhựa dẻo', 50000, 100000, 'https://cdn.tgdd.vn/Products/Images/60/222929/op-oppo-a91-deo-tail-tpu-case-cosano-xanh-teal-1-600x600.jpg', 10, 3.5, 5, '2021-08-16', 3, 8),
(23, 'Ốp lưng Oppo F11 Pro Nhựa cứng viền dẻo', 125000, 250000, 'https://cdn.tgdd.vn/Products/Images/60/212639/op-f11-pro-vien-deo-tempered-osmia-xanh-navy-do-1-600x600.jpg', 10, 5, 2, '2021-08-16', 3, 8),
(24, 'Ốp lưng Oppo A52/A92 Nhựa dẻo', 50000, 100000, 'https://cdn.tgdd.vn/Products/Images/60/225553/op-lung-oppo-a52-a92-deo-line-pattern-xanh-teal-1-600x600.jpg', 10, 4.5, 4, '2021-08-16', 3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `shipping_address`
--

CREATE TABLE `shipping_address` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `country` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `postal_code` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lat` int(11) NOT NULL,
  `lng` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `shipping_address`
--

INSERT INTO `shipping_address` (`id`, `fullname`, `address`, `city`, `country`, `postal_code`, `lat`, `lng`) VALUES
(1, 'Trương Dương Khang', 'Ấp Cái Tràm A1, Long Thạnh, Vĩnh Lợi ', 'Bạc Liêu', 'Việt Nam', '0', 0, 0),
(2, 'Adminsator', 'TP Bạc Liêu', 'Bạc Liêu', 'Việt Nam', '0', 0, 0),
(3, 'Huỳnh Hồng Hân', 'Ấp Cái Dày, Châu Hưng, Vĩnh Lợi ', 'Bạc Liêu', 'Việt Nam', '0', 0, 0),
(4, 'Trương Nhựt Huy', 'Ấp Cái Tràm A1, Long Thạnh, Vĩnh Lợi ', 'Bạc Liêu', 'Việt Nam', '0', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_admin` tinyint(1) NOT NULL,
  `is_seller` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `is_admin`, `is_seller`) VALUES
(2, 'Duong khang', 'duongkhang@gmail.com', '123456', 1, 0),
(3, 'Admin', 'admin@gmail.com', 'admin', 1, 1),
(4, 'Hồng Hân', 'honghan1303@gmail.com', '123456', 0, 1),
(5, 'Nhựt Huy', 'nhuthuy0901@gmail.com', '123456', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_order_item_order` (`order_item_id`),
  ADD KEY `fk_shipping_address_order` (`shipping_address_id`),
  ADD KEY `fk_user_order` (`user_id`),
  ADD KEY `fk_payment_method_orders` (`payment_method_id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_order_item` (`product_id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_category_product` (`category_id`),
  ADD KEY `fk_brand_product` (`brand_id`);

--
-- Indexes for table `shipping_address`
--
ALTER TABLE `shipping_address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `shipping_address`
--
ALTER TABLE `shipping_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
