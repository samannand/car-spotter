package sga111.seng440.carspotter.ui.spotting

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import sga111.seng440.carspotter.AppNavigation
import sga111.seng440.carspotter.R
import sga111.seng440.carspotter.entities.Car

class SpottingFragment : Fragment() {

    private lateinit var spottingViewModel: SpottingViewModel
    private lateinit var editMakeView: EditText
    private lateinit var editModelView: EditText
    private lateinit var editYearView: EditText
    private var galleryCode: Int = 1
    private lateinit var imageText: TextView
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotting, container, false)
        spottingViewModel = ViewModelProvider(this).get(SpottingViewModel::class.java)

        editMakeView = view.findViewById(R.id.edit_make)
        editModelView = view.findViewById(R.id.edit_model)
        editYearView = view.findViewById(R.id.edit_year)
        imageView = view.findViewById(R.id.car_image_view)

        val button = view.findViewById<Button>(R.id.add_to_collection)
        val photoButton : Button = view.findViewById(R.id.photo_button)

        button.setOnClickListener {
            if (TextUtils.isEmpty(editMakeView.text) || TextUtils.isEmpty(editModelView.text) || TextUtils.isEmpty(editYearView.text)) {
                Toast.makeText(
                    context!!,
                    R.string.empty_fields,
                    Toast.LENGTH_LONG).show()
                val mShakeAnimation = AnimationUtils.loadAnimation(context!!, R.anim.button_shake);
                button.startAnimation(mShakeAnimation)
            } else {
                val car = Car(editMakeView.text.toString(), editModelView.text.toString(), editYearView.text.toString().toInt(), null)
                spottingViewModel.insert(car)
                clearValues()
                view.findNavController().navigate(R.id.navigation_collection)
            }
        }

        photoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            intent.type = "image/*"
            startActivityForResult(intent, galleryCode)

        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == galleryCode) {
            var imageUri: Uri? = data?.data

            imageView.setImageURI(imageUri)
            spottingViewModel.imageUri = imageUri
        }

    }

    private fun clearValues() {
        editMakeView.setText("")
        editYearView.setText("")
        editModelView.setText("")
    }
}
