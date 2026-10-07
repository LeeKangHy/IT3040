package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* ====================================================================
 *  PHẦN 1: THÔNG TIN SINH VIÊN
 * ==================================================================== */
private const val schoolNameVi = "ĐẠI HỌC"
private const val schoolNameVii= "BÁCH KHOA HÀ NỘI"

private const val schoolNameEn = "HANOI UNIVERSITY"
private const val schoolNameEnii = "OF SCIENCE AND TECHNOLOGY"

private const val studentName  = "Lê Viết Tùng"
private const val majorVi      = "TRƯỜNG CÔNG NGHỆ THÔNG TIN VÀ TRUYỀN THÔNG"
private const val majorEn      = "School of Information and Communication Technology"
private const val dateOfBirth  = "12/05/2003"
private const val studentId    = "202117893"
private const val course       = "K66"
private const val validUntil   = "30/07/2025"

// Ảnh sinh viên
private val studentPhoto = R.drawable.personall
// Ảnh logo hust
private val logoHust = R.drawable.logo_hust
// Ảnh QR
private val QR = R.drawable.qr_code
/* ====================================================================
 *  PHẦN 2: MÀU SẮC
 * ==================================================================== */
private val AccentRed = Color(0xFFC62828)
private val TextDark = Color(0xFF212121)
private val TextGray = Color(0xFF616161)
private val ScreenBackground = Color(0xFFE9E4DA)

/* ====================================================================
 *  PHẦN 3: ACTIVITY
 * ==================================================================== */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                StudentCardScreen()
            }
        }
    }
}

/* ====================================================================
 *  PHẦN 4: GIAO DIỆN
 * ==================================================================== */

// Màn hình: nền + đặt card ở giữa
@Composable
fun StudentCardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground),
        contentAlignment = Alignment.Center
    ) {
        StudentCard()
    }
}

// Thẻ sinh viên (bố cục dọc, bo góc, nền trắng)
@Composable
fun StudentCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .widthIn(max = 340.dp)
            .aspectRatio(0.64f),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardHeader()

            Spacer(modifier = Modifier.height(8.dp))
            // Đường kẻ ngang
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(AccentRed)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "THẺ SINH VIÊN",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )
            Text(
                text = "Student ID Card",
                fontSize = 12.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(10.dp))
            // Ảnh sinh viên (chữ nhật bo góc)
            Image(
                painter = painterResource(id = studentPhoto),
                contentDescription = "Student Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(15.dp))
            // Họ tên
            Text(
                text = studentName.uppercase(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(5.dp))
            // Tên  (Tiếng Việt)
            Text(
                text = majorVi,
                fontSize = 10.sp,
                lineHeight = 10.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = majorEn,
                fontSize = 10.sp,
                lineHeight = 10.sp,
                color = TextDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // Đẩy phần thông tin xuống cuối card
            Spacer(modifier = Modifier.weight(1f))

            CardFooterInfo()

            Spacer(modifier = Modifier.height(6.dp))

        }
    }
}

// Khu vực logo + tên trường
@Composable
fun CardHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Ô giữ chỗ cho logo
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(4.dp) ),
            contentAlignment = Alignment.Center
        ){
            Image(
            painter = painterResource(id = logoHust),
            contentDescription = "Logo Hust Picture",
            )
        }

        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.height(70.dp),
        ) {
            Text(
                text = schoolNameVi,
                fontSize = 11.sp,
                lineHeight = 9.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Text(
                text = schoolNameVii,
                fontSize = 11.sp,
                lineHeight = 9.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )
            Text(
                text = schoolNameEn,
                fontSize = 11.sp,
                lineHeight = 9.sp,
                color = TextGray
            )
            Text(
                text = schoolNameEnii,
                fontSize = 11.sp,
                lineHeight = 9.sp,
                color = TextGray
            )
        }
    }
}

// Phần cuối card: thông tin bên trái, ô giữ chỗ bên phải
@Composable

fun CardFooterInfo() {
    Row(
        modifier = Modifier.fillMaxWidth()
                            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            InfoRow(label = "Ngày sinh/ DOB", value = dateOfBirth)
            InfoRow(label = "MSSV/ Student ID", value = studentId)
            InfoRow(label = "Khóa/ Course", value = course)
            InfoRow(label = "Giá trị đến/ Valid until", value = validUntil)
        }

        // Mã QR
        Image(
            painter = painterResource(id = QR),
            contentDescription = "QR Code",

            modifier = Modifier
                .size(60.dp)
        )

    }
}

// Một dòng thông tin: "Nhãn : Giá trị"
@Composable
fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier) {
        Text(
            text = label,
            fontSize = 10.sp,
            lineHeight = 10.sp ,
            color = TextGray,
            modifier = Modifier.width(120.dp)
        )
        Text(
            text = ": $value",
            fontSize = 10.sp,
            lineHeight = 10.sp ,
            fontWeight = FontWeight.Bold,
            color = TextDark
        )
    }
}

/* ====================================================================
 *  PHẦN 5: PREVIEW
 * ==================================================================== */
@Preview(showBackground = true)
@Composable
fun StudentCardPreview() {
    MaterialTheme {
        StudentCardScreen()
    }
}