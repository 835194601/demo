//package com.hystrix;
//
//import com.google.common.collect.ImmutableList;
//import com.google.common.collect.Lists;
//import com.netflix.hystrix.*;
//
//import java.util.*;
//
//public class GetInfoFromSinaiCommand extends HystrixCommand<List<PoiInfo>> {
//    private PoiClient poiClient;
//    private List<Integer> poiIds;
//    private static final List<String> FIELDS = ImmutableList.of("id", "cate", "subcate");
//
//    public GetInfoFromSinaiCommand(PoiClient poiClient, List<Integer> poiIds) {
//        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("sinai"))
//                //command配置
//                .andCommandKey(HystrixCommandKey.Factory.asKey("GetInfoFromSinaiCommand"))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withRequestCacheEnabled(true))
//
//                //融断器配置
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerEnabled(true))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerRequestVolumeThreshold(20))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerSleepWindowInMilliseconds(5000))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerErrorThresholdPercentage(50))
//
//                //ThreadPool配置
//                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("GetInfoFromSinaiCommand"))
//                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10))
//                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(-1))
//
//        );
//
//
//        this.poiClient = poiClient;
//        this.poiIds = poiIds;
//
//    }
//
//    @Override
//    public List<PoiInfo> run() throws Exception {
//        if (poiIds.isEmpty()) {
//            return Lists.newArrayList();
//        }
//        List<PoiModel> pioModels = poiClient.listPois(poiIds, FIELDS);
//        return parseResult(pioModels);
//    }
//
//    @Override
//    protected String getCacheKey() {
//        return String.valueOf(poiIds);
//    }
//
//    @Override
//    protected List<PoiInfo> getFallback() {
//        return Lists.newArrayList();
//    }
//
//    private List<PoiInfo> parseResult(List<PoiModel> poiModels) {
//        if (poiModels == null || poiModels.isEmpty()) {
//            return Lists.newArrayList();
//        }
//        List<PoiInfo> res = Lists.newArrayList();
//        for (PoiModel poiModel : poiModels) {
//            PoiInfo poiInfo = new PoiInfo();
//            poiInfo.setPoiId(poiModel.getId());
//
//            if (poiModel.getCate() != null) {
//                poiInfo.setCate(poiModel.getCate());
//            }
//            if (poiModel.getSubcate() != null) {
//                poiInfo.setSubcate(poiModel.getSubcate());
//            }
//            res.add(poiInfo);
//        }
//        return res;
//
//    }
//}
