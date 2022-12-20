package com.example.appdev2finalproject.SidebarOptions.ViewHotels;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;

public class ViewHotels extends Fragment {
    RecyclerView recyclerView;
    public int[] imageUrls;
    View rootView;
    Button aiai, ew, vip, trans, trivago;


    public ViewHotels() {
        // Required empty public constructor
    }

    public static ViewHotels newInstance(String param1, String param2) {
        ViewHotels fragment = new ViewHotels();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_view_hotels, container, false);
        //find all the buttons
        aiai = rootView.findViewById(R.id.aiai);
        ew = rootView.findViewById(R.id.ew);
        vip = rootView.findViewById(R.id.vip);
        trivago = rootView.findViewById(R.id.trivago);
        trans = rootView.findViewById(R.id.transButton);
//        loadHotels(recyclerView);

        //for hotel details page

        //buttons tracker
        aiai.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "";
                String hotelDesc = "";
                int price = 14;
                Hotel hotel = null;
                TextView hotelName = rootView.findViewById(R.id.aiAiHotel); // Hotel Name
                name = hotelName.getText().toString();
                TextView hotelDescc = rootView.findViewById(R.id.aiaiHotelDesc); // Hotel Description
                hotelDesc = hotelDescc.getText().toString();
                price = 14; // price for hotel per day
                hotel = new Hotel(name, hotelDesc, price);
                switchActivity(hotel);
            }
        });


        ew.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "";
                String hotelDesc = "";
                int price = 10;
                Hotel hotel = null;
                TextView hotelName = rootView.findViewById(R.id.ewHotel); // Hotel Name
                name = hotelName.getText().toString();
                TextView hotelDescc = rootView.findViewById(R.id.ewHotelDesc); // Hotel Description
                hotelDesc = hotelDescc.getText().toString();
                price = 14; // price for hotel per day
                hotel = new Hotel(name, hotelDesc, price);
                switchActivity(hotel);
            }
        });

        vip.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "";
                String hotelDesc = "";
                int price = 50;
                Hotel hotel = null;
                TextView hotelName = rootView.findViewById(R.id.vipHotel); // Hotel Name
                name = hotelName.getText().toString();
                TextView hotelDescc = rootView.findViewById(R.id.vipHotelDesc); // Hotel Description
                hotelDesc = hotelDescc.getText().toString();
                price = 14; // price for hotel per day
                hotel = new Hotel(name, hotelDesc, price);
                switchActivity(hotel);
            }
        });

        trivago.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "";
                String hotelDesc = "";
                int price = 25;
                Hotel hotel = null;
                TextView hotelName = rootView.findViewById(R.id.trivagoHotel); // Hotel Name
                name = hotelName.getText().toString();
                TextView hotelDescc = rootView.findViewById(R.id.trivagoHotelDesc); // Hotel Description
                hotelDesc = hotelDescc.getText().toString();
                price = 14; // price for hotel per day
                hotel = new Hotel(name, hotelDesc, price);
                switchActivity(hotel);
            }
        });

        trans.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "";
                String hotelDesc = "";
                int price = 30;
                Hotel hotel = null;
                TextView hotelName = rootView.findViewById(R.id.transHotel); // Hotel Name
                name = hotelName.getText().toString();
                TextView hotelDescc = rootView.findViewById(R.id.transHotelDesc); // Hotel Description
                hotelDesc = hotelDescc.getText().toString();
                price = 14; // price for hotel per day
                hotel = new Hotel(name, hotelDesc, price);
                switchActivity(hotel);
            }
        });
        return rootView;
    }

    public void switchActivity(Hotel hotel) {

//        FragmentManager fragmentManager = getChildFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, BookHotelFragment);
//        fragmentTransaction.commit();
        HotelDetailsFragment hotelDetailsFragment = new HotelDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("hotelInfo", hotel);
        hotelDetailsFragment.setArguments(args);
          getFragmentManager().beginTransaction().replace(R.id.fragment_container, hotelDetailsFragment).commit();

//        Intent switchActivity = new Intent(getActivity(), HotelDetails.class);
//        switchActivity.putExtra("hotelInfo", hotel);
//        startActivity(switchActivity);
    }


//    public void goToHotelPage(View view){
//
//
//
//        switch (view.getId()) {
//            case R.id.aiAiHotelImg:
//                //img, name, more description of hotel, button to go to checkout of that hotel(custom price)
//
//
//                break;
//            case R.id.transHotelImg:
////img, name, more description of hotel, button to go to checkout of that hotel(custom price)
//
//                TextView transHotelName = rootView.findViewById(R.id.transHotel); // Hotel Name
//                name = transHotelName.getText().toString();
//
//                hotelDesc = ""; // Hotel Description
//
//                price = 30; // price for hotel per day
//
//                hotel = new Hotel(name, hotelDesc, price);
//                switchActivity();
//                break;
//            case R.id.imageView4:
//
//                //img, name, more description of hotel, button to go to checkout of that hotel(custom price)
//
//                TextView trivagoName = rootView.findViewById(R.id.trivagoHotel); // Hotel Name
//                name = trivagoName.getText().toString();
//
//                hotelDesc = ""; // Hotel Description
//
//                price = 20; // price for hotel per day
//
//                hotel = new Hotel(name, hotelDesc, price);
//                switchActivity();
//                break;
//            case R.id.ewHotelImg:
//
//                //img, name, more description of hotel, button to go to checkout of that hotel(custom price)
//
//                TextView ewHotelName = rootView.findViewById(R.id.ewHotel); // Hotel Name
//                name = ewHotelName.getText().toString();
//
//                hotelDesc = ""; // Hotel Description
//
//                price = 14; // price for hotel per day
//
//                hotel = new Hotel(name, hotelDesc, price);
//                switchActivity();
//                break;
//            case R.id.imageView5:
//
//                //img, name, more description of hotel, button to go to checkout of that hotel(custom price)
//
//                TextView vipHotelName = rootView.findViewById(R.id.vipHotel); // Hotel Name
//                name = vipHotelName.getText().toString();
//
//                hotelDesc = ""; // Hotel Description
//
//                price = 50; // price for hotel per day
//
//                hotel = new Hotel(name, hotelDesc, price);
//                switchActivity();
//                break;
//
//
//        }


//        public void loadHotels (RecyclerView recyclerView){
//            ArrayList<String> hotelNames = new ArrayList<>(Arrays.asList("Hotel Transelvannia", "Hotel Trivago", "Hotel Vanhorne",
//                    "Hotel VIP", "Hotel Ai Ai"));
//            ArrayList<String> hotelDescs = new ArrayList<>(Arrays.asList("Hotel Transelvannia for all the freaks and monsters", "Trivago the only option", "Vanhorne nothing to tell",
//                    "Only for VIP", "Hotel where Ai Ai happens"));
//            //give arrayList from here or firebase
//            imageUrls = new int[]{R.drawable.trans, R.drawable.trivago, R.drawable.ew, R.drawable.vip, R.drawable.aiai};
//            ViewHotelsAdapter adapter = new ViewHotelsAdapter(hotelNames, hotelDescs, imageUrls, getActivity());
//            recyclerView.setAdapter(adapter);
//            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        }
//    }
}
