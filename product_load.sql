-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.27 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Dumping data for table tfcom_articles.product: ~4 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`, `name`, `partnumber`, `description`, `thumbnail_url`, `buyable`, `unitprice`) VALUES
	(3, 'Samsung Galaxy S6', '4372036', 'Carefully crafted from metal and glass, the Galaxy S6 and Galaxy S6 edge blend purposeful design with powerful features. The Galaxy S6 edge, particularly, shows unique and outstanding beauty while also providing a solid grip and an immersive viewing experience with the world\'s first curved display on both sides. The Galaxy S6 and Galaxy S6 edge are equipped with an incredibly vivid, bright and fast front and rear camera. The Galaxy S6 and Galaxy S6 edge are built on the upgraded Samsung Knox, end-to-end secure mobile platform, offering defense-grade features for real-time protection from potential malicious attacks.', '/images/sg6.jpg', 'Y', 699.99),
	(4, 'Nokia Lumia 930', '260665', 'The Nokia Lumia 930 comes with the latest Windows Phone experience, so the things that matter most are always with you whether you’re on your smartphone, Xbox or PC. Exclusive LiveTiles keep you up to speed with what’s happening in your world, while new features like customisable background images for your home screen make Windows Phone 8.1 more personal than ever.', '/images/lumia930.jpg', 'Y', 349.00),
	(6, 'Nexus 6', '1161032', 'Sleek and stunning, the Nexus 6 has something for everyone. Whether you are watching movies or sending emails on-the-go, the impressive 6” Quad HD display and long lasting battery life makes this phone the perfect life accessory. Why it rocks: The Nexus 6 is more than just a phone, it’s a personal assistant that offers more of everything. Its advanced 13MP rear-facing camera and 2.0MP front-facing camera allow you to snap crystal clear pictures of moments that matter. The new Android 5.0 Lollipop OS offers brighter colors, richer animations and sharper shapes. With the ability to gain 7 hours of battery life from just 15 minutes of charge with the Turbo Charger, the Nexus 6 lets you do more of what you want. Environmental certification: Certified by the UL Environment.', '/images/nexus6.png', 'Y', 549.00),
	(7, 'Apple iPhone 6 Smartphone 64 GB', '7618003', 'iPhone 6 isn\'t just bigger, it\'s better in every way. A smooth metal surface seamlessly meets the new retina HD display. It features leading-edge technologies, including the power efficient A8 chip with M8 motion co-processor, a new iSight camera with focus pixels and advanced video capabilities, and faster LTE and Wi-Fi all in the thinnest iPhone ever. iPhone 6 comes with iOS 8, which delivers a simpler, faster, and more intuitive user experience with new messages and photos features, predictive typing for the quick-type keyboard, family sharing, the new health app, iCloud drive, and more.', '/images/iphone6.jpg', 'Y', 757.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
