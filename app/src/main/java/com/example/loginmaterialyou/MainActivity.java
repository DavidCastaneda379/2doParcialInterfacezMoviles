package com.example.loginmaterialyou;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.chip.Chip;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private MaterialCheckBox cbRemember;
    private TextView tvStatusMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Activa Material You (Dynamic Color) en Android 12+ (API 31+)
        DynamicColors.applyToActivityIfAvailable(this);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inicializarVistas();
        configurarEventos();
    }

    private void inicializarVistas() {
        tilEmail = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        cbRemember = findViewById(R.id.cbRemember);
        tvStatusMessage = findViewById(R.id.tvStatusMessage);
        Chip chipMaterialYou = findViewById(R.id.chipMaterialYou);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            chipMaterialYou.setText("Material You: Color Dinámico Activo");
        } else {
            chipMaterialYou.setText("Material 3: Esquema Tonal Estándar");
        }
    }

    private void configurarEventos() {
        MaterialButton btnLogin = findViewById(R.id.btnLogin);
        MaterialButton btnRegister = findViewById(R.id.btnRegister);
        TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);

        btnLogin.setOnClickListener(v -> validarEIniciarSesion());

        tvForgotPassword.setOnClickListener(v -> {
            tvStatusMessage.setText("Se envió un enlace de recuperación a tu correo.");
            tvStatusMessage.setVisibility(View.VISIBLE);
        });

        btnRegister.setOnClickListener(v -> {
            tvStatusMessage.setText("Módulo de registro disponible en la siguiente vista.");
            tvStatusMessage.setVisibility(View.VISIBLE);
        });
    }

    private void validarEIniciarSesion() {
        String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString() : "";

        tilEmail.setError(null);
        tilEmail.setErrorEnabled(false);
        tilPassword.setError(null);
        tilPassword.setErrorEnabled(false);
        tvStatusMessage.setVisibility(View.GONE);

        boolean esValido = true;

        if (TextUtils.isEmpty(email)) {
            tilEmail.setError("Ingresa tu correo electrónico");
            esValido = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError("Formato de correo no válido");
            esValido = false;
        }

        if (TextUtils.isEmpty(password)) {
            tilPassword.setError("Ingresa tu contraseña");
            esValido = false;
        } else if (password.length() < 6) {
            tilPassword.setError("Mínimo 6 caracteres");
            esValido = false;
        }

        if (esValido) {
            String estadoSesion = cbRemember.isChecked()
                    ? "Sesión persistente activada."
                    : "Sesión temporal.";

            new MaterialAlertDialogBuilder(this)
                    .setIcon(R.drawable.ic_lock)
                    .setTitle("Autenticación Exitosa")
                    .setMessage("Bienvenido, " + email + ".\n" + estadoSesion
                            + "\n\nInterfaz ejecutada en Java con Material 3 y Material You.")
                    .setPositiveButton("Continuar", (dialog, which) -> dialog.dismiss())
                    .show();
        }
    }
}