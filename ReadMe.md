# ParasitiferView #

通常会有这样的情况，需要通过几个控件合在一起成为一个组合控件，以降低耦合。但是，写一个组合控件比较费时费力，而且通用性较低。  
故有此项目，来解决此问题。  
	
	Parasitifer:宿主  
	Parasyte:寄生兽  

	ParasyteAdapter寄生于ParasitiferView之中，故取名ParasitiferView
  

ParasitiferView类似于Fragment，但又比Fragment轻量级  

1. 可以直接传值，无需考虑Fragment 转屏 所引起的bug 和各种Fragment潜在的bug
2. 没有生命周期，比起Fragment，ParasitiferView更像是Activity里的一个View
2. ParasitiferView只负责UI的更新，更符合单一职责原则  
3. 各个Parasyte(Adapter)之间，无论是怎样的布局方式、数据类型，都可随意切换 
4. 小，很小。只有30个Method

## 添加依赖 ##


## 使用 ##

### 在 Activity xml 中添加 ###

	<com.ethanco.parasitiferview.ParasitiferView
        android:id="@+id/parasitifer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />  

### 新建Adapter，继承自ParasyteAdapter ###

	public class WeatherAdapter extends ParasyteAdapter<String> {
	    public WeatherAdapter(Context context, String data) {
	        super(context, data);
	    }
	
	    @Override
	    public View getView() {
	        View view = mInflater.inflate(R.layout.layout_weather, null);
	        TextView tvTemper = (TextView) view.findViewById(R.id.tv_temper);
	
	        tvTemper.setText(data);
	        return view;
	    }
	}

### 在Activity中添加 ###

	parasitifer.setAdapter(new WeatherAdapter(MainActivity.this, "59"));  